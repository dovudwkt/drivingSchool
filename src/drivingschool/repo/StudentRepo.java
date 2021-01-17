package drivingschool.repo;

import java.sql.Connection;
import drivingschool.Helpers;
import drivingschool.entity.Lesson;
import drivingschool.entity.Student;

import javax.swing.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepo {

    Connection conn;
    public static List students;

    public void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
        connect();

    }

    public void connect() throws SQLException, ClassNotFoundException {
        String url, user, pw;
        url = "jdbc:mysql://localhost:3306/drivingschool";
        user = "root";
        pw = "password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(url, user, pw);
        System.out.println("Connected !");

    }

//    public static void testStudent() throws ParseException {
//        try {
//            System.out.printf("\n Tests for Class Student\n\n");
//            System.out.printf("\n addStudent() ...\n");
//            addStudent("Ali", "Faisal", "Turkey ", "1993-06-19", "beginner", "12548612", "2025-05-12");
//            addStudent("Ayse", "Kemaller", "Cyprus", "1998-09-28", "intermediate", "12546845", "2024-02-10");
//            addStudent("Muhammad", "Fahrad", "Iran", "1996-05-30", "on hold", "32156879", "2025-12-04");
//            addStudent("Fatima ", "Reshad", "Syria", "1998-07-22", "beginner", "18855312", "2026-04-28");
//
//            listStudents();
//            System.out.printf("\n\n\n editStudent()\n");
//            editStudent("186731", "Ayse", "Kemaller", "Turkey", "1998-09-28", "intermediate", "1232456", "2025-10-22");
//            listStudents();
//
//            System.out.printf("\n\n Backing up...\n");
//            backupStudent();
//
//            System.out.printf("\n deleteStudent() whose std ID is 189222\n");
//            deleteStudent("189222");
//            listStudents();
//
//            System.out.printf("\n\n\n Retrieving backed up data...\n");
//            retrieveStudent();
//            listStudents();
//
//            System.out.printf("\n\n\n ListGrades()\n");
//            listGrades();
//
//        } catch (IOException | ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Error");
//        }
//    }
    public static void populateData() {
        try {
            addStudent("Ali", "Faisal", "Turkey ", "1993-06-19", "beginner", "12548612", "2025-05-12");
            addStudent("Ayse", "Kemaller", "Cyprus", "1998-09-28", "intermediate", "12546845", "2024-02-10");
            addStudent("Muhammad", "Fahrad", "Iran", "1996-05-30", "on hold", "32156879", "2025-12-04");
            addStudent("Fatima ", "Reshad", "Syria", "1998-07-22", "beginner", "18855312", "2026-04-28");
            backupStudent();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PaymentRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void retrieveStudent() throws IOException, ClassNotFoundException {
        students = Helpers.readFile("backups/students.dat");
    }

    public static void backupStudent() throws IOException {
        Helpers.writeFile(students, "backups/students.dat");
    }

    public static void addStudent(String name, String surname, String nationality, String dob, String status, String licenceNo, String licenceExp) {
//        Student st = new Student(name, surname, nationality, LocalDate.parse(dob), status, LocalDate.now(), licenceNo, LocalDate.parse(licenceExp));
        Student st = new Student(name, surname, nationality, dob, status, licenceExp, licenceNo, LocalDate.now().toString());
        students.add(st);
    }

    public static void editStudent(String stdNo, String name, String surname, String nationality, String dob, String status, String licenceNo, String licenceExpire) {
        Student st = null;
        boolean found = false;
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            st = itr.next();
            if (stdNo.equals(st.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            st.setName(name);
            st.setSurname(surname);
            st.setNationality(nationality);
            st.setDOB(dob);
            st.setStatus(status);
            st.setLicenceNo(licenceNo);
            st.setLicenceExpire(licenceExpire);
        }
    }

    public static void deleteStudent(String stdNoo) {
        Student st = null;
        boolean found = false;

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            st = itr.next();
            if (stdNoo.equals(st.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            students.remove(st);
        }
    }

    public static void listStudents() {
        Student st;
        Iterator<Student> itr = students.iterator();
        System.out.printf("\n%-10s %-15s %-15s %-10s %-15s %-15s %-15s %-15s %-15s %-15s", "Student No", "Name", "Surname", "Nationality", "Birthday", "Status", "Registered at", "Licence No", "Licence type", "Licence Expire");
        Helpers.drawLine(Helpers.EXTRA_LARGE_LINE);

        while (itr.hasNext()) {
            st = itr.next();
            System.out.printf("\n%-10s %-15s %-15s %-10s %-15s %-15s %-15s %-15s %-15s %-15s",
                    st.getID(),
                    st.getName(),
                    st.getSurname(),
                    st.getNationality(),
                    st.getDOB(),
                    st.getStatus(),
                    st.getRegisterDate(),
                    st.getLicenceNo(),
                    st.getLicenceType(),
                    st.getLicenceExpire());
        }
        Helpers.drawLine(Helpers.EXTRA_LARGE_LINE);
    }

    public static void listGrades() {
        try {
            Student st;
            Lesson lesson;

            List lessons = Helpers.readFile("backups/lessons.dat");

            System.out.printf("\n%-10s %-15s %-15s %-10s %-15s %-10s", "Student No", "Name", "Surname", "Lesson No", "Date", "Grade");
            Helpers.drawLine(Helpers.LARGE_LINE);

            Iterator<Student> itr = students.iterator();
            while (itr.hasNext()) {
                st = itr.next();
                System.out.printf("\n%-10s %-15s %-15s ",
                        st.getID(),
                        st.getName(),
                        st.getSurname());

                Iterator<Lesson> lessonItr = lessons.iterator();
                while (lessonItr.hasNext()) {
                    lesson = lessonItr.next();
                    if (lesson.getStudentID().equals(st.getID())) {
                        System.out.printf("%-10s %-15s %-10s", lesson.getLessonNo(), lesson.getLessonDate(), lesson.getGrade());
                        break;
                    }
                }
            }
            Helpers.drawLine(Helpers.LARGE_LINE);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StudentRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getNameByID(int id) {
        Student s;

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            s = itr.next();
            if (id == s.getID()) {
                return s.getName() + " " + s.getSurname();
            }
        }
        return "";
    }

    public void addStudent2(String name, String surname, String nationality, String dob, String status, String licenceNo, String licenceExp) {
        try {
            Student st = new Student(name, surname, nationality, dob, status, LocalDate.now().toString(), licenceNo,licenceExp);
            students.add(st);
            var q = "insert into student(first_name, last_name, nationality, dob, licence_no, licence_expire) Values (?,?,?,?,?,?)";
            var pstmt = conn.prepareStatement(q);
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, nationality);
            pstmt.setString(4, dob);
            pstmt.setInt(5, Integer.parseInt(licenceNo));
            pstmt.setString(6, licenceExp);
            pstmt.setString(7, status);

            System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
