/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dovud
 */
public class DB {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "drivingschool";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "password";
    private static final String BACKUP_PATH = "backup.sql";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/drivingschool";

    public DB() {}
    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection(JDBC_URL, DB_USER, DB_PWD);

        System.out.println("Connected to MYSQL");
        return conn;
    }

    public static void backup() {
        String dumpCommand = "mysqldump " + DB_NAME + " -h " + HOST + " -u " + DB_USER + " -p" + DB_PWD;
        Runtime rt = Runtime.getRuntime();
        File test = new File(BACKUP_PATH);
        PrintStream ps;

        try {
            Process child = rt.exec(dumpCommand);
            ps = new PrintStream(test);
            InputStream in = child.getInputStream();
            int ch;
            while ((ch = in.read()) != -1) {
                ps.write(ch);
                System.out.write(ch);
            }

            InputStream err = child.getErrorStream();
            while ((ch = err.read()) != -1) {
                System.out.write(ch);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static boolean restore() {
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Restore");
            // Call cmd of mysql:
            String mysql = "mysql -u" + DB_USER + " -p" + DB_PWD + " " + DB_NAME;
            Process child = rt.exec(mysql);
            OutputStream out = child.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(BACKUP_PATH), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);

            writer.flush();
            out.close();
            br.close();
            writer.close();
            System.out.println("Restore success");
        } catch (Exception e) {
            System.out.println("Restore failed");
            e.printStackTrace();
        }
        return true;
    }
}
