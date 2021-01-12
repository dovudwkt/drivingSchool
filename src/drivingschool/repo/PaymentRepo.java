package drivingschool.repo;

import drivingschool.Helpers;
import drivingschool.entity.Payment;
import drivingschool.entity.Student;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PaymentRepo {

    public static List payments;

    public static void main(String[] args) throws ParseException {
        payments = new ArrayList();
        testPayment();
        System.out.printf("\n");
    }

    public static void testPayment() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Payment\n\n");
            System.out.printf("\n addPayment() ...\n");

            addPayment("1234", "116229", 1500.0, "Partial payment");
            addPayment("1235", "186731", 1500.0, "");
            addPayment("1236", "168337", 2000.0, "Two month payment");
            addPayment("1321", "189222", 1800.0, "");
            listPayments();

            System.out.printf("\n\n\n editPayment() edit Ali Faisal's payment amount \n");
            editPayment("1234", "116229", 2000.0, "Full payment");
            listPayments();

            System.out.printf("\n\n Backing up...\n");
            backupPayments();

            System.out.printf("\n deletePayment() Delete the Ayse Kemaller’s record from payments\n");
            deletePayment("1235");
            listPayments();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrievePayments();
            listPayments();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public static void populateData() {
        try {
            addPayment("1234", "116229", 1500.0, "Partial payment");
            addPayment("1235", "186731", 1500.0, "");
            addPayment("1236", "168337", 2000.0, "Two month payment");
            addPayment("1321", "189222", 1800.0, "");
            backupPayments();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PaymentRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void retrievePayments() throws IOException, ClassNotFoundException {
        payments = Helpers.readFile("backups/payments.dat");
    }

    public static void backupPayments() throws IOException {
        Helpers.writeFile(payments, "backups/payments.dat");
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
            if (id.equals(p.getID())) {
                found = true;
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

        Iterator<Payment> itr = payments.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (pID.equals(p.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            payments.remove(p);
        }
    }

    public static void listPayments() throws IOException, ClassNotFoundException {
        Payment payment;
        Student student;

        List students = Helpers.readFile("backups/students.dat");

        System.out.printf("\n%-10s %-15s %-12s %-20s %-32s %-15s", "PaymentID", "StudentID", "Amount", "Comment", "Timestamp", "Student Name");
        Helpers.drawLine(Helpers.LARGE_LINE);

        Iterator<Payment> itr = payments.iterator();
        while (itr.hasNext()) {
            payment = itr.next();
            System.out.printf("\n%-10s %-15s %-12s %-20s %-32s ",
                    payment.getID(),
                    payment.getStudentID(),
                    payment.getAmount(),
                    payment.getComment(),
                    payment.getTimestamp());

            Iterator<Student> stdItr = students.iterator();
            while (stdItr.hasNext()) {
                student = stdItr.next();
                if (student.getID().equals(payment.getStudentID())) {
                    System.out.print(student.getName() + " " + student.getSurname());
                }
            }
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }

}
