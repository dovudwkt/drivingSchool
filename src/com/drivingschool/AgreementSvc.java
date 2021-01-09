package com.drivingschool;

import com.drivingschool.entity.Agreement;
import com.drivingschool.entity.Package;
import com.drivingschool.entity.Student;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgreementSvc {
    public static List agreements;

    public static void main(String[] args) throws ParseException {
        agreements = new ArrayList();
        testAgreement();
        System.out.printf("\n");
    }
    public static void testAgreement() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Agreement\n\n");
            System.out.printf("\n addAgreement() ...\n");

            addAgreement("45621","116229","1202","2021-01-05");
            addAgreement("45622","189222","1201","2021-01-05");
            addAgreement("45623","168337","1204","2021-01-10");
            listAgreements();

            System.out.printf("\n\n\n editAgreement() Edit start date of agreement of the student with ID 189222\n");
            editAgreement("45622","189222","1201","2021-01-18");

            listAgreements();

            System.out.printf("\n\n Backing up...\n");
            backupAgreements();

            System.out.printf("\n deleteAgreement()  Cancel agreements with student whose ID=45623\n");
            deleteAgreement("45623");
            listAgreements();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveAgreements();
            listAgreements();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrieveAgreements() throws IOException, ClassNotFoundException {
        agreements = Helpers.readFile("agreements.dat");
    }
    public static void backupAgreements() throws IOException {
       Helpers.writeFile(agreements, "agreements.dat");
    }

    public static void addAgreement(String id, String stdID, String pkgID, String startDate) {
        Agreement a = new Agreement(id, stdID, pkgID, LocalDate.parse(startDate));
        agreements.add(a);
    }

    public static void editAgreement(String id, String stdID, String pkgID, String startDate) {
        Agreement p = null;
        boolean found = false;
        Iterator<Agreement> itr = agreements.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(id.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) {
            p.setStudentID(stdID);
            p.setPackageID(pkgID);
            p.setStartDate(LocalDate.parse(startDate));
        }
    }

    public static void deleteAgreement(String ID) {
        Agreement p = null;
        boolean found = false;

        Iterator <Agreement> itr = agreements.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(ID.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) agreements.remove(p);
    }

    public static void listAgreements() throws IOException, ClassNotFoundException {
        Agreement agreement;
        Student student;
        Package pkg;

        List students = Helpers.readFile("students.dat");
        List packages = Helpers.readFile("packages.dat");


        System.out.printf("\n%-10s %-20s %-15s %-20s", "ID", "Start Date", "Package", "Student Name" );
        Helpers.drawLine(Helpers.LARGE_LINE);

        Iterator <Agreement> itr = agreements.iterator();
        while (itr.hasNext()) {
            agreement = itr.next();

            System.out.printf("\n%-10s %-20s ",agreement.getID(), agreement.getStartDate());

            Iterator <Package> pkgItr = packages.iterator();
            while (pkgItr.hasNext()) {
                pkg = pkgItr.next();
                if (pkg.getID().equals(agreement.getPackageID())) {
                    System.out.printf("%-15s ",pkg.getName());
                }
            }
            Iterator <Student> stdItr = students.iterator();
            while (stdItr.hasNext()) {
                student = stdItr.next();
                if (student.getID().equals(agreement.getStudentID())) {
                    System.out.print(student.getName()+" "+student.getSurname());
                }
            }
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }
}
