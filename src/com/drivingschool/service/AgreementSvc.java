package com.drivingschool.service;

import java.time.LocalDate;
import java.util.List;
import com.drivingschool.entity.Agreement;

public class AgreementSvc {
    public static List agreements;

    public static void testAgreement() {
        Agreement agreement = new Agreement("12","17701937","201", LocalDate.now());
        System.out.printf("\n%-10s %-15s %-15s %-20s", "ID", "Student ID", "Package ID", "Start Date");
        System.out.printf("\n%-10s %-15s %-15s %-20s",
                agreement.getID(),
                agreement.getStudentID(),
                agreement.getPackageID(),
                agreement.getStartDate());
    }
}
