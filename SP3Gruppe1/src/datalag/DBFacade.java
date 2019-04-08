
package datalag;

import businesslogic.Pizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
