
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NITHIN
 */
public class Mydb {
    
    Connection con;
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bmtcsbpp","root","Amp@4044308");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Mydb.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
