package com.drivingschool.service;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.drivingschool.Helpers;
import com.drivingschool.entity.Student;

import javax.swing.*;

public class StudentSvc {
    public static List students;

    public static void testStudent() throws ParseException {
//        Student student = new Student("177", "Dovud", "Inomov", "Tajik", LocalDate.parse("2016-08-16"), "New student",  LocalDate.now());
//
//        System.out.printf("\n%-10s %-15s %-15s %-15s %-15s %-15s %-10s\n", "ID", "Name", "Surname", "Nationality", "DOB","Status","RegisterDate");
//        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-10s",
//                student.getID(),
//                student.getName(),
//                student.getSurname(),
//                student.getNationality(),
//                student.getDOB(),
//                student.getStatus(),
//                student.getRegisterDate());
        try {
            System.out.printf("\n Tests for Class Student\n\n");
            System.out.printf("\n addStudent() ...\n");
            addStudent("177", "Dovud", "Inomov", "Tajik", "1999-02-28", "New student");
            addStudent("178", "Henry", "Colins", "British", "1989-02-26", "New student");
            listStudents();
            System.out.printf("\n\n\n editStudent() whose std ID is 186731 \n");
            editStudent("178", "Henry", "Colins", "Canadian", "1989-02-26", "Old student");
            listStudents();

            System.out.printf("\n\n Backing up...\n");
            backupStudent();

            System.out.printf("\n deleteStudent() whose std ID is 177\n");
            deleteStudent("177");
            listStudents();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveStudent();
            listStudents();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrieveStudent() throws IOException, ClassNotFoundException
    {
        File infile  = new File("students.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        students = (ArrayList)inObjectStream.readObject();

        inObjectStream.close();

    }
    public static void backupStudent() throws IOException
    {
        File outfile  = new File("students.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);

        outObjectStream.writeObject(students);
        outObjectStream.close();

    }

    public static void addStudent(String stdNo, String name, String surname, String nationality, String dob, String status) {
        Student st = new Student(stdNo, name, surname, nationality, LocalDate.parse(dob), status, LocalDate.now());
        students.add(st);
    }

    public static void editStudent(String stdNo, String name, String surname, String nationality, String dob, String status) {
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
        System.out.printf("\n%10s %15s %15s %10s %12s %12s", "Student No","Std. Name", "Std. Surname","Nationality", "Birthday", "Status", "Registered at");
        Helpers.drawLine(Helpers.LARGE_LINE);

        while (itr.hasNext()) {
            st = itr.next();
            System.out.printf("\n%10s %15s %15s %10s %12s %12s %15 %15",
                    st.getID(),
                    st.getName(),
                    st.getSurname(),
                    st.getNationality(),
                    st.getDOB(),
                    st.getStatus(),
                    st.getRegisterDate());
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }

}
