package com.drivingschool;

import com.drivingschool.entity.Payment;
import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PaymentSvc {
    public static List payments;
    public static void main(String[] args) throws ParseException {
        payments = new ArrayList();
        testPayment();
        System.out.printf("\n");
    }

    public static void testPayment() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Package\n\n");
            System.out.printf("\n addPayment() ...\n");

            addPayment("1","17701937",1500.0, "First payment");
            addPayment("2","12354895",1800.0, "First payment");
            listPayments();

            System.out.printf("\n\n\n editPayment() where ID = 2 \n");
            editPayment("2","12354895",1700, "Return 100");
            listPayments();

            System.out.printf("\n\n Backing up...\n");
            backupPayments();

            System.out.printf("\n deletePayment() whose std ID is 1\n");
            deletePayment("1");
            listPayments();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrievePayments();
            listPayments();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrievePayments() throws IOException, ClassNotFoundException
    {
        File infile  = new File("payments.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        payments = (ArrayList)inObjectStream.readObject();

        inObjectStream.close();

    }
    public static void backupPayments() throws IOException
    {
        File outfile  = new File("payments.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);

        outObjectStream.writeObject(payments);
        outObjectStream.close();

    }

    public static void addPayment(String id, String studentID, double amount, String comment) {
        Payment pm = new Payment(id, studentID, amount, new Date(), comment);
        payments.add(pm);
    }

    public static void editPayment(String id, String studentID, double amount, String comment) {
        Payment p = null;
        boolean found = false;
        Iterator<Payment> itr = payments.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(id.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) {
            p.setAmount(amount);
            p.setComment(comment);
            p.setTimestamp(new Date());
        }
    }

    public static void deletePayment(String pID) {
        Payment p = null;
        boolean found = false;

        Iterator <Payment> itr = payments.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(pID.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) payments.remove(p);
    }

    public static void listPayments() {
        Payment p;
        Iterator <Payment> itr = payments.iterator();
        System.out.printf("\n%10s %15s %12s %20s %20s", "PaymentID", "StudentID", "Amount","Comment", "Timestamp");
        Helpers.drawLine(Helpers.LARGE_LINE);

        while (itr.hasNext()) {
            p = itr.next();
            System.out.printf("\n%10s %15s %12s %20s %20s",
                    p.getID(),
                    p.getStudentID(),
                    p.getAmount(),
                    p.getComment(),
                    p.getTimestamp());
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }

}
