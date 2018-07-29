/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author quochung
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public DBConnection() {
    }

    public Connection getConnecttion() {
        try {
            String url = "jdbc:mysql://localhost:3306/javaweb?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "9800162hung";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver is failed");
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } catch (InstantiationException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
