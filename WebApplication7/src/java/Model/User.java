/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author quochung
 */
import java.sql.Connection;
import java.sql.*;
import DB.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private String id, pass;

    public User() {
        id = "";
        pass = "";
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean LoginUser(){
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT * FROM users WHERE id = ? and pass = ?";   
        if(con!=null){
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ptm.setString(1, id);
                ptm.setString(2, pass);
                ResultSet rs = ptm.executeQuery();
                if(rs.next())
                {
                    ptm.close();
                    con.close();
                    return true;
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public String test(){
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT * FROM users WHERE id = ?";   
        if(con!=null){
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ptm.setString(1, id);
                ResultSet rs = ptm.executeQuery();
                if(rs.next())
                {
                    ptm.close();
                    con.close();
                    return rs.getString("pass");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        return "this is null";
    }
}
