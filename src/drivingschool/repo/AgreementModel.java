/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import drivingschool.entity.Agreement;

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
public class AgreementModel {

    Connection conn;
    public static List agreements;

    public AgreementModel() {
        try {
            DB db = new DB();
            conn = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AgreementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Agreement> getAgreements() {
        List agreements = new ArrayList();

        try {
            var pstmt = conn.prepareStatement("select * from agreement");
            var rs = pstmt.executeQuery();

            Agreement l;

            while (rs.next()) {
                int id = rs.getInt("id");
                int package_id = rs.getInt("package_id");
                int student_id = rs.getInt("student_id");
                String start_date = rs.getString("start_date");

                l = new Agreement(id, student_id, package_id, start_date);
                agreements.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgreementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return agreements;
    }

    public int deleteAgreement(int id) throws SQLException {
        var q = "delete from agreement WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        return result;
    }

    public void addAgreement(int studentID, int packageID, String startDate) {
        try {
            var q = "insert into agreement(student_id, package_id, start_date) Values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, studentID);
            pstmt.setInt(2, packageID);
            pstmt.setString(3, startDate);

            pstmt.executeUpdate();
            System.out.println("The New agreement Data is Recorded Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(AgreementModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editAgreement(int id, int studentID, int packageID, String startDate) {
        try {
            var q = "UPDATE agreement set package_id = ?, student_id = ?, start_date = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, packageID);
            pstmt.setInt(2, studentID);
            pstmt.setString(3, startDate);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            System.out.println("Edited successfully");

        } catch (SQLException ex) {
            Logger.getLogger(AgreementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Agreement getAgreementById(int pkgID) {
        Agreement l = null;

        try {
            var q = "Select * from agreement WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, pkgID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int package_id = rs.getInt("package_id");
                int student_id = rs.getInt("student_id");
                String start_date = rs.getString("start_date");

                l = new Agreement(id, student_id, package_id, start_date);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgreementModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }
}
