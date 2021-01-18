/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dovud
 */
public class DB {
    
    public Connection connect() throws SQLException, ClassNotFoundException {
        String url, user, pw;
        url = "jdbc:mysql://localhost:3306/drivingschool";
        user = "root";
        pw = "password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(url, user, pw);

        System.out.println("Connected to MYSQL");
        return conn;
    }
}
