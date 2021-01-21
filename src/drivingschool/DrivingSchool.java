/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool;

import drivingschool.repo.AgreementRepo;
import drivingschool.repo.LessonRepo;
import drivingschool.repo.PackageRepo;
import drivingschool.repo.PaymentRepo;
import drivingschool.repo.StudentRepo;

import drivingschool.GUI.Menu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dovud
 */
public class DrivingSchool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentRepo.students = new ArrayList();
        PaymentRepo.payments = new ArrayList();
        PackageRepo.packages = new ArrayList();
        LessonRepo.lessons = new ArrayList();
        AgreementRepo.agreements = new ArrayList();

        populateAllData();
        new Menu().setVisible(true);

    }

    public static void populateAllData() {
//        AgreementRepo.populateData();
        //            LessonRepo.populateData();
        PackageRepo.populateData();
        PaymentRepo.populateData();
        StudentRepo.populateData();
    }

}
