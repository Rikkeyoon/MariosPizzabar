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
import presentation.UI;

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
    private UI ui;

    public DBFacade(UI ui) {
        this.ui = ui;
    }

    public void visMenukort() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM pizzaer");
            while (result.next()) {
                int pizzaNr = result.getInt(1);
                String pizzaNavn = result.getString(2);
                String toppings = result.getString(3);
                double pris = result.getDouble(4);

                ui.visMenukort(new Pizza(pizzaNr, pizzaNavn, toppings, pris));
            }
        } catch (SQLException e) {

        }
    }

    public void visBestillinger() {
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

                ui.visBestillinger(new Bestilling(bestilNr, afhentTid,
                        new Bestillingslinje(antal, pizzaNr)));
            }
        } catch (SQLException e) {

        }
    }

    public void gemBestilling() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            int brugerValg = ui.vælgBestilNrPåBestillingSomGemmes();
            statement.executeLargeUpdate("INSERT INTO gemte_bestillinger (bestilnr, afhenttid) SELECT bestilnr, afhenttid \n"
                    + "FROM bestillinger WHERE bestillinger.bestilnr = " + brugerValg);
            statement.executeLargeUpdate("INSERT INTO gemte_bestillingslinjer (antal, pizzanr, bestilnr) SELECT antal, pizzanr, bestilnr "
                    + "FROM bestillingslinjer WHERE bestillingslinjer.bestilnr = " + brugerValg);
            statement.executeLargeUpdate("DELETE FROM bestillingslinjer WHERE bestilnr =" + brugerValg);
            statement.executeLargeUpdate("DELETE FROM bestillinger WHERE bestilnr =" + brugerValg);
        } catch (SQLException e) {

        }
    }

    public void visGemteBestillinger() {
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

                ui.visGemteBestillinger(new Bestilling(bestilNr, afhentTid,
                        new Bestillingslinje(antal, pizzaNr)));
            }
        } catch (SQLException e) {

        }
    }

    public void opretBestilling() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            int pizzaNr = ui.vælgPizzalNr();
            int antal = ui.vælgAntal();
            LocalTime afhentTid = ui.vælgAfhentTid();

            statement.executeLargeUpdate("INSERT INTO bestillinger(afhenttid) "
                    + "VALUE ('" + afhentTid + "')");
            int bestilNr = findBestilNr();
            statement.executeLargeUpdate("INSERT INTO bestillingslinjer(antal, pizzanr, bestilnr) "
                    + "VALUES (" + antal + ", " + pizzaNr + ", " + bestilNr + ")");

        } catch (SQLException e) {

        }
    }
    public int findBestilNr(){
        int bestilNr = 0;
        
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() FROM bestillinger");
            bestilNr = result.getInt(1);
        } catch (SQLException e) {

        }
        return bestilNr;
    }

    public void visPizzaNavn() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            int pizzaNr = ui.vælgPizzalNr();
            ResultSet result = statement.executeQuery("SELECT pizzanavn FROM pizzaer "
                    + "WHERE pizzanr = " + pizzaNr);
            while (result.next()) {
                String pizzaNavn = result.getString(2);
                
                ui.visPizzaNavn(pizzaNavn);
            }

        } catch (SQLException e) {

        }
    }
}
