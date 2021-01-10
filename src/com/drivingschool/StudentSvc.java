package com.drivingschool;

import com.drivingschool.entity.Lesson;
import com.drivingschool.entity.Student;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentSvc {
    public static List students;
    public static void main(String[] args) throws ParseException {
        students = new ArrayList();
        testStudent();
        System.out.printf("\n");
    }

    public static void testStudent() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Student\n\n");
            System.out.printf("\n addStudent() ...\n");
            addStudent("116229", "Ali", "Faisal", "Turkey ", "1993-06-19", "beginner");
            addStudent("186731", "Ayse", "Kemaller", "Cyprus", "1998-09-28", "intermediate");
            addStudent("168337", "Muhammad", "Fahrad", "Iran", "1996-05-30", "on hold");
            addStudent("189222", "Fatima ", "Reshad", "Syria", "1998-07-22", "beginner");


            listStudents();
            System.out.printf("\n\n\n editStudent()\n");
            editStudent("186731", "Ayse", "Kemaller", "Turkey", "1998-09-28", "intermediate", "Category A", "1232456", "2025-10-22");
            listStudents();

            System.out.printf("\n\n Backing up...\n");
            backupStudent();

            System.out.printf("\n deleteStudent() whose std ID is 189222\n");
            deleteStudent("189222");
            listStudents();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveStudent();
            listStudents();

            System.out.printf("\n\n\n ListGrades()\n");
            listGrades();

        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrieveStudent() throws IOException, ClassNotFoundException {
        students = Helpers.readFile("students.dat");
    }
    public static void backupStudent() throws IOException {
        Helpers.writeFile(students, "students.dat");
    }

    public static void addStudent(String stdNo, String name, String surname, String nationality, String dob, String status) {
        Student st = new Student(stdNo, name, surname, nationality, LocalDate.parse(dob), status, LocalDate.now());
        students.add(st);
    }

    public static void editStudent(String stdNo, String name, String surname, String nationality, String dob, String status, String licenceType, String licenceNo, String licenceExpire) {
        Student st = null;
        boolean found = false;
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            st = itr.next();
            if(stdNo.equals(st.getID())) {
                found=true;
                break;
            }
        }
        if (found) {
            st.setName(name);
            st.setSurname(surname);
            st.setNationality(nationality);
            st.setDOB(LocalDate.parse(dob));
            st.setStatus(status);
            st.setLicenceType(licenceType);
            st.setLicenceNo(licenceNo);
            st.setLicenceExpire(LocalDate.parse(licenceExpire));
        }
    }

    public static void deleteStudent(String stdNoo) {
        Student st = null;
        boolean found = false;

        Iterator <Student> itr = students.iterator();
        while (itr.hasNext()) {
            st = itr.next();
            if(stdNoo.equals(st.getID())) {
                found=true;
                break;
            }
        }
        if (found) students.remove(st);
    }

    public static void listStudents() {
        Student st;
        Iterator <Student> itr = students.iterator();
        System.out.printf("\n%-10s %-15s %-15s %-10s %-15s %-15s %-15s %-15s %-15s %-15s", "Student No", "Name", "Surname","Nationality", "Birthday", "Status", "Registered at", "Licence No", "Licence type","Licence Expire");
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

    public static void listGrades() throws IOException, ClassNotFoundException {
        Student st;
        Lesson lesson;

        List lessons = Helpers.readFile("lessons.dat");

        System.out.printf("\n%-10s %-15s %-15s %-10s %-15s %-10s", "Student No", "Name", "Surname", "Lesson No", "Date", "Grade");
        Helpers.drawLine(Helpers.LARGE_LINE);

        Iterator <Student> itr = students.iterator();
        while (itr.hasNext()) {
            st = itr.next();
            System.out.printf("\n%-10s %-15s %-15s ",
                    st.getID(),
                    st.getName(),
                    st.getSurname());

            Iterator <Lesson> lessonItr = lessons.iterator();
            while (lessonItr.hasNext()) {
                lesson = lessonItr.next();
                if(lesson.getStudentID().equals(st.getID())) {
                    System.out.printf("%-10s %-15s %-10s", lesson.getLessonNo(), lesson.getLessonDate(), lesson.getGrade());
                    break;
                }
            }
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }
}
