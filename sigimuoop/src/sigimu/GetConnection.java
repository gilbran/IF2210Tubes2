/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

/**
 *
 * @author andi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mahdan Ahmad F A
 */
public class GetConnection {

    Connection conn = null;
    String serverName;
    String dataBaseName;
    String userName;
    String password;

    public GetConnection() {
        this.serverName = "localhost";
        this.dataBaseName = "sigimuoop1";
        this.userName = "root";
        this.password = "";
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + serverName + "/" + dataBaseName,"root","");
        return conn;
    }
    
//    public static void main(String [] args) {
//        GetConnection gc = new GetConnection();
//        try {
//            gc.getConnection();
//            System.out.println("bisa konek");
//        }
//        catch (Exception e) {
//            System.out.println("g isa konek");
//        } 
//    }
}
