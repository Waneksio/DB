package pl.put.poznan;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.put.poznan.Controller;
import pl.put.poznan.mainForm.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        new loginForm();
        //new mainForm();
        /*Connection conn = null;
        try {
            conn = Controller.login("inf136823", "inf136823");
        }
        catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "nie udało się połączyć z bazą danych", ex);
            System.exit(-1);
        }

        String tableName = "pracownicy";
        String query = "select * from pracownicy";
        Controller controller = new Controller();

        try {
            controller.displayResult(conn, query, tableName);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
