/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quochung
 */
public class DBConnection {
      public DBConnection() {
    }

    public Connection getConnecttion()  {
        try {
          String url="jdbc:mysql://localhost:3306/articledb?autoReconnect=true&useSSL=false";
            String user = "root";
            String password= "9800162hung";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url,user,password);   
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
