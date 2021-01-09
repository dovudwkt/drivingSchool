package com.drivingschool;

import com.drivingschool.entity.Agreement;
import com.drivingschool.entity.Agreement;

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

            addAgreement("12","1235","201","2021-02-05");
            addAgreement("14","3214","203","2021-02-21");
            listAgreements();

            System.out.printf("\n\n\n editAgreement() where ID = 2 \n");
            editAgreement("14","3214","201","2021-02-10");

            listAgreements();

            System.out.printf("\n\n Backing up...\n");
            backupAgreements();

            System.out.printf("\n deleteAgreement() whose std ID is 1\n");
            deleteAgreement("12");
            listAgreements();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveAgreements();
            listAgreements();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrieveAgreements() throws IOException, ClassNotFoundException
    {
        File infile  = new File("agreements.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        agreements = (ArrayList)inObjectStream.readObject();

        inObjectStream.close();

    }
    public static void backupAgreements() throws IOException
    {
        File outfile  = new File("agreements.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);

        outObjectStream.writeObject(agreements);
        outObjectStream.close();

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

    public static void listAgreements() {
        Agreement a;
        Iterator <Agreement> itr = agreements.iterator();

        System.out.printf("\n%-10s %-15s %-15s %-20s", "ID", "Student ID", "Agreement ID", "Start Date");
        Helpers.drawLine(Helpers.LARGE_LINE);



        while (itr.hasNext()) {
            a = itr.next();
            System.out.printf("\n%-10s %-15s %-15s %-20s",
                    a.getID(),
                    a.getStudentID(),
                    a.getPackageID(),
                    a.getStartDate());
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }
}
