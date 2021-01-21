/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import drivingschool.GUI.JFrame_StudentAdd;
import drivingschool.entity.CoursePackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dovud
 */
public class PackageModel {

    Connection conn;
    public static List students;

    public PackageModel() {
        try {
            DB db = new DB();
            conn = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PackageModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<CoursePackage> getPackages() {
        List pkgs = new ArrayList();

        try {
            var pstmt = conn.prepareStatement("select * from package");
            var rs = pstmt.executeQuery();

            CoursePackage p;

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int numLessons = rs.getInt("num_lessons");

                p = new CoursePackage(id, name, price, numLessons);
                pkgs.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PackageModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pkgs;
    }

    public int deletePackage(int id) throws SQLException {
        var q = "delete from package WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        return result;
    }

    public void addPackage(String name, double price, int numLessons) {
        try {
            var q = "insert into package(name, price, num_lessons) Values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, numLessons);

            pstmt.executeUpdate();
            System.out.println("The New package Data is Recorded Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(PackageModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editPackage(int id, String name, double price, int numLessons) {
        try {
            var q = "update package set name = ?, price = ?, num_lessons = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, numLessons);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            System.out.println("Edited successfully");

        } catch (SQLException ex) {
            Logger.getLogger(JFrame_StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public CoursePackage getPackageById(int pkgID) {
        CoursePackage pkg = null;

        try {
            var q = "Select * from package WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, pkgID);
            ResultSet rs = pstmt.executeQuery();
            int id, numLessons;
            String name;
            double price;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                price = rs.getDouble("price");
                numLessons = rs.getInt("num_lessons");

                pkg = new CoursePackage(id, name, price, numLessons);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PackageModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pkg;

    }
}
