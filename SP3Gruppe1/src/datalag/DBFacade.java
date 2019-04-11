package datalag;

import businesslogic.Bestilling;
import businesslogic.Bestillingslinje;
import businesslogic.Pizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * @author Rikke, Nina og Caroline
 */
public class DBFacade {

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String IP = "localhost";
    private final String PORT = "3306";
    private final String DATABASE = "mariospizzabar";
    private final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE
            + "?useJDBCcompliantTimeZoneShift=true&"
            + "useLegacyDatetimeCode=false&serverTimezone=UTC";

    public ArrayList<Pizza> hentMenukort() {
        ArrayList<Pizza> pizzaer = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pizzaer");
            while (result.next()) {
                int pizzaNr = result.getInt(1);
                String pizzaNavn = result.getString(2);
                String toppings = result.getString(3);
                double pris = result.getDouble(4);

                pizzaer.add(new Pizza(pizzaNr, pizzaNavn, toppings, pris));
            }
        } catch (SQLException e) {

        }
        return pizzaer;
    }

    public ArrayList<Bestilling> hentBestillinger() {
        ArrayList<Bestilling> bestillinger = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM bestillinger "
                    + "NATURAL JOIN bestillingslinjer");
            while (result.next()) {
                int bestilNr = result.getInt(1);
                Time sqlTid = result.getTime(2);
                LocalTime afhentTid = sqlTid.toLocalTime();
                int antal = result.getInt(3);
                int pizzaNr = result.getInt(4);

                bestillinger.add(new Bestilling(bestilNr, afhentTid,
                        new Bestillingslinje(antal, pizzaNr)));
            }
        } catch (SQLException e) {

        }
        return bestillinger;
    }

    public void gemAfsluttetBestilling(int brugerValg) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeLargeUpdate("INSERT INTO gemte_bestillinger (bestilnr, afhenttid) SELECT bestilnr, afhenttid \n"
                    + "FROM bestillinger WHERE bestillinger.bestilnr = " + brugerValg);
            statement.executeLargeUpdate("INSERT INTO gemte_bestillingslinjer (antal, pizzanr, bestilnr) SELECT antal, pizzanr, bestilnr "
                    + "FROM bestillingslinjer WHERE bestillingslinjer.bestilnr = " + brugerValg);
            statement.executeLargeUpdate("DELETE FROM bestillingslinjer WHERE bestilnr =" + brugerValg);
            statement.executeLargeUpdate("DELETE FROM bestillinger WHERE bestilnr =" + brugerValg);
        } catch (SQLException e) {

        }
    }

    public ArrayList<Bestilling> hentGemteBestillinger() {
        ArrayList<Bestilling> bestillinger = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM gemte_bestillinger "
                    + "NATURAL JOIN gemte_bestillingslinjer");
            while (result.next()) {
                int bestilNr = result.getInt(1);
                Time sqlTid = result.getTime(2);
                LocalTime afhentTid = sqlTid.toLocalTime();
                int antal = result.getInt(3);
                int pizzaNr = result.getInt(4);

                bestillinger.add(new Bestilling(bestilNr, afhentTid,
                        new Bestillingslinje(antal, pizzaNr)));
            }
        } catch (SQLException e) {

        }
        return bestillinger;
    }

    public void gemBestilling(Bestilling bestilling) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            statement.executeLargeUpdate("INSERT INTO bestillinger(afhenttid) "
                    + "VALUE ('" + bestilling.getAfhentTid() + "')");
//            int bestilNr = findBestilNr();
        } catch (SQLException e) {

        }
    }
    
    public void gemBestillingslinje(Bestilling bestilling) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeLargeUpdate("INSERT INTO bestillingslinjer(antal, pizzanr, bestilnr) "
                   + "VALUES (" + bestilling.getBestilLinje().getAntal() 
                    + ", " + bestilling.getBestilLinje().getPizzaNr() 
                    + ", " + bestilling.getBestilNr() + ")");

        } catch (SQLException e) {

        }
    }
    



}