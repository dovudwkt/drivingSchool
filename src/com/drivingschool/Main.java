package com.drivingschool;


import java.text.ParseException;
import java.util.ArrayList;

import static com.drivingschool.StudentSvc.*;
import static com.drivingschool.LessonSvc.*;
import static com.drivingschool.PaymentSvc.*;
import static com.drivingschool.PackageSvc.*;
import static com.drivingschool.AgreementSvc.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        students = new ArrayList();
        payments = new ArrayList();
        packages = new ArrayList();
        lessons = new ArrayList();
        agreements = new ArrayList();

        testStudent(); Helpers.lineBreak(5);
        testPayment(); Helpers.lineBreak(5);
        testAgreement(); Helpers.lineBreak(5);
        testPackage(); Helpers.lineBreak(5);
        testLesson(); Helpers.lineBreak(5);
    }
}
