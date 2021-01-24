/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import drivingschool.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dovud
 */
public class PaymentModel {

    Connection conn;
    public static List students;

    public PaymentModel() {
        try {
            DB db = new DB();
            conn = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Payment> getPayments() {
        List payments = new ArrayList();

        try {
            var pstmt = conn.prepareStatement("select * from payment");
            var rs = pstmt.executeQuery();

            Payment p;

            while (rs.next()) {
                int id = rs.getInt("id");
                int std_id = rs.getInt("student_id");
                double amount = rs.getDouble("amount");
                String timestamp = rs.getString("timestamp");
                String comment = rs.getString("comment");

                p = new Payment(id, std_id, amount, timestamp, comment);
                payments.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return payments;
    }

    public int deletePayment(int id) throws SQLException {
        var q = "delete from payment WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        return result;
    }

    public void addPayment(int studentID, double amount, String comment) {
        try {
            var q = "insert into payment(student_id, amount, timestamp, comment) Values (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, studentID);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, new Date().toString());
            pstmt.setString(4, comment);

            pstmt.executeUpdate();
            System.out.println("The New payment Data is Recorded Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editPayment(int id, int studentID, double amount, String comment) {
        try {
            var q = "update payment set student_id = ?, amount = ?, comment= ?, timestamp = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, studentID);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, comment);
            pstmt.setString(4, new Date().toString());
            pstmt.setInt(5, id);

            pstmt.executeUpdate();
            System.out.println("Edited successfully");

        } catch (SQLException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Payment getPaymentById(int pkgID) {
        Payment p = null;

        try {
            var q = "Select * from payment WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, pkgID);
            ResultSet rs = pstmt.executeQuery();
         
            while (rs.next()) {
                int id = rs.getInt("id");
                int std_id = rs.getInt("student_id");
                double amount = rs.getDouble("amount");
                String timestamp = rs.getString("timestamp");
                String comment = rs.getString("comment");

                p = new Payment(id, std_id, amount, timestamp, comment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
