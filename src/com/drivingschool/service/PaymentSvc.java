package com.drivingschool.service;

import java.util.Date;
import java.util.List;

import com.drivingschool.entity.Payment;

public class PaymentSvc {
    public static List payments;

    public static void testPayment() {
        Date timestamp = new Date();
        Payment payment = new Payment("1","17701937",1500.0, timestamp, "First payment");

        System.out.printf("\n%-10s %-15s %-15s %-20s %-20s", "ID", "Student ID", "Amount", "Comment",  "Timestamp");
        System.out.printf("\n%-10s %-15s %-15s %-20s %-20s",
                payment.getID(),
                payment.getStudentID(),
                payment.getAmount(),
                payment.getComment(),
                payment.getTimestamp());
    }
}
