/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import drivingschool.GUI.JFrame_StudentAdd;
import drivingschool.GUI.JFrame_StudentList;
import drivingschool.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dovud
 */
public class StudentModel {

    Connection conn;
    public static List students;

    public StudentModel() {
        try {
            DB db = new DB();
            conn = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Student> getStudents() {
        List stds = new ArrayList();

        try {
            var pstmt = conn.prepareStatement("select * from student");
            var rs = pstmt.executeQuery();

            Student s;

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("first_name");
                String surname = rs.getString("last_name");
                String nationality = rs.getString("nationality");
                String birthday = rs.getString("dob");
                String registerDate = rs.getString("register_date");
                String licenceNo = rs.getString("licence_no");
                String licenceExp = rs.getString("licence_expire");
                String status = rs.getString("status");

                s = new Student(id, name, surname, nationality, birthday, status, licenceExp, licenceNo, registerDate);
                stds.add(s);

            }
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stds;
    }

    public int deleteStudent(int id) throws SQLException {
        var q = "delete from student WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        return result;
    }

    public void addStudent(String name, String surname, String nationality, String dob, String status, String licenceNo, String licenceExp) {
        try {
            var q = "insert into student(first_name, last_name, nationality, dob, licence_no, licence_expire, status, register_date) Values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, nationality);
            pstmt.setString(4, dob);
            pstmt.setString(5, licenceNo);
            pstmt.setString(6, licenceExp);
            pstmt.setString(7, status);
            pstmt.setString(8, LocalDate.now().format(DateTimeFormatter.ISO_DATE));

            System.out.println(pstmt);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "The New Student Data is Recorded Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editStudent(int id, String name, String surname, String nationality, String dob, String status, String licenceNo, String licenceExp) {
        try {
            var q = "update student set first_name = ?, last_name = ?, nationality = ?, dob = ?, licence_no = ?, licence_expire = ?, status = ?  WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, nationality);
            pstmt.setString(4, dob);
            pstmt.setString(5, licenceNo);
            pstmt.setString(6, licenceExp);
            pstmt.setString(7, status);
            pstmt.setInt(8, id);

            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_StudentAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getStudentById(int stdId) {
        Student std = null;

        try {
            var q = "Select * from student WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, stdId);

            ResultSet rs = pstmt.executeQuery();

            int id;
            String name, surname, nationality, dob, licenceNo, licenceExp, registerDate, status;

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("first_name");
                surname = rs.getString("last_name");
                nationality = rs.getString("nationality");
                dob = rs.getString("dob");
                licenceNo = rs.getString("licence_no");
                licenceExp = rs.getString("licence_expire");
                registerDate = rs.getString("register_date");
                status = rs.getString("status");

                std = new Student(id, name, surname, nationality, dob, status, licenceExp, licenceNo, registerDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return std;
    }
}
