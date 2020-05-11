/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.*;
public class koneksi {
    Connection conn = null;
    
    public static Connection getKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/elektronik";
            String user = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url,user,pass);
            return conn;
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }
    
}
