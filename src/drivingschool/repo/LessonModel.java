/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.repo;

import drivingschool.GUI.JFrame_StudentAdd;
import drivingschool.entity.Lesson;

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
public class LessonModel {

    Connection conn;
    public static List lessons;

    public LessonModel() {
        try {
            DB db = new DB();
            conn = db.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LessonModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Lesson> getLessons() {
        List lessons = new ArrayList();

        try {
            var pstmt = conn.prepareStatement("select * from lesson");
            var rs = pstmt.executeQuery();

            Lesson l;

            while (rs.next()) {
                int id = rs.getInt("id");
                int package_id = rs.getInt("package_id");
                int student_id = rs.getInt("student_id");
                int lesson_no = rs.getInt("lesson_no");
                String lesson_date = rs.getString("lesson_date");
                String start_time = rs.getString("start_time");
                String end_time = rs.getString("end_time");
                String grade = rs.getString("grade");

                l = new Lesson(id, package_id, student_id, lesson_no, lesson_date, start_time, end_time, grade);
                lessons.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lessons;
    }

    public int deleteLesson(int id) throws SQLException {
        var q = "delete from lesson WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(q);
        pstmt.setInt(1, id);
        int result = pstmt.executeUpdate();
        System.out.println("Number of records affected :: " + result);
        return result;
    }

    public void addLesson(int packageID, int studentID, int lessonNo, String lessonDate, String startTime, String endTime, String grade) {
        try {
            var q = "insert into lesson(package_id, student_id, lesson_no, lesson_date, start_time, end_time, grade) Values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, packageID);
            pstmt.setInt(2, studentID);
            pstmt.setInt(3, lessonNo);
            pstmt.setString(4, lessonDate);
            pstmt.setString(5, startTime);
            pstmt.setString(6, endTime);
            pstmt.setString(7, grade);

            pstmt.executeUpdate();
            System.out.println("The New lesson Data is Recorded Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(LessonModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editLesson(int id, int packageID, int studentID, int lessonNo, String lessonDate, String startTime, String endTime, String grade) {
        try {
            var q = "UPDATE lesson set package_id = ?, student_id = ?, lesson_no = ?, lesson_date = ?, start_time = ?, end_time = ?, grade = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, packageID);
            pstmt.setInt(2, studentID);
            pstmt.setInt(3, lessonNo);
            pstmt.setString(4, lessonDate);
            pstmt.setString(5, startTime);
            pstmt.setString(6, endTime);
            pstmt.setString(7, grade);
            pstmt.setInt(8, id);

            pstmt.executeUpdate();
            System.out.println("Edited successfully");

        } catch (SQLException ex) {
            Logger.getLogger(LessonModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Lesson getLessonById(int pkgID) {
        Lesson l = null;

        try {
            var q = "Select * from lesson WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, pkgID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int package_id = rs.getInt("package_id");
                int student_id = rs.getInt("student_id");
                int lesson_no = rs.getInt("lesson_no");
                String lesson_date = rs.getString("lesson_date");
                String start_time = rs.getString("start_time");
                String end_time = rs.getString("end_time");
                String grade = rs.getString("grade");

                l = new Lesson(id, package_id, student_id, lesson_no, lesson_date, start_time, end_time, grade);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;

    }
}
