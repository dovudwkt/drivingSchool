/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

/**
 *
 * @author dovud
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MySQLDumper {

    private static String ip = "localhost";
    private static String port = "3306";
    private static String database = "drivingschool";
    private static String user = "root";
    private static String pass = "password";
    private static String path = "backup.sql";

    public static void backup() {
        String dumpCommand = "mysqldump " + database + " -h " + ip + " -u " + user + " -p" + pass;
        Runtime rt = Runtime.getRuntime();
        File test = new File(path);
        PrintStream ps;

        try {
            Process child = rt.exec(dumpCommand);
            ps = new PrintStream(test);
            InputStream in = child.getInputStream();
            int ch;
            while ((ch = in.read()) != -1) {
                ps.write(ch);
                System.out.write(ch); //to view it by console
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
            String mysql = "mysql -u" + user + " -p" + pass + " " + database;
            Process child = rt.exec(mysql);
            OutputStream out = child.getOutputStream();// Input from the console as an output stream
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf8"));
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

    public static void main(String args[]) throws IOException, InterruptedException {
//        export();
//        importDB();
//        load();
    }
}
