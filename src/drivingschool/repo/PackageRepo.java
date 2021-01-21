package drivingschool.repo;

import drivingschool.Helpers;
import drivingschool.entity.CoursePackage;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PackageRepo {

    public static List packages;

    public static void main(String[] args) throws ParseException {
        packages = new ArrayList();
        System.out.printf("\n");
    }

//    public static void testPackage() throws ParseException {
//        try {
//            System.out.printf("\n Tests for Class CoursePackage\n\n");
//            System.out.printf("\n addPackage() ...\n");
//
//            addPackage("1201", "Pro", 2000.0, 30);
//            addPackage("1202", "Standard", 1500.0, 12);
//            addPackage("1204", "Intense", 1800.0, 20);
//            listPackages();
//
//            System.out.printf("\n\n\n editPackage() Edit price for Standard package to 1400  \n");
//            editPackage("1202", "Standard", 1400.0, 12);
//            listPackages();
//
//            System.out.printf("\n\n Backing up...\n");
//            backupPackages();
//
//            System.out.printf("\n deletePackage() Delete “Pro” package \n");
//            deletePackage("1201");
//            listPackages();
//
//            System.out.printf("\n\n\n Retrieving backed up data...\n");
//            retrievePackages();
//            listPackages();
//        } catch (IOException | ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Error");
//        }
//    }

    public static void populateData() {
        try {
            addPackage(1201, "Pro", 2000.0, 30);
            addPackage(1202, "Standard", 1500.0, 12);
            addPackage(1204, "Intense", 1800.0, 20);
            backupPackages();
        } catch (IOException ex) {
            Logger.getLogger(PackageRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void retrievePackages() throws IOException, ClassNotFoundException {
        packages = Helpers.readFile("backups/packages.dat");
    }

    public static void backupPackages() throws IOException {
        Helpers.writeFile(packages, "backups/packages.dat");
    }

    public static void addPackage(int id, String name, double price, int numLessons) {
        CoursePackage p = new CoursePackage(id, name, price, numLessons);
        packages.add(p);
    }

    public static void editPackage(String id, String name, double price, int numLessons) {
        CoursePackage p = null;
        boolean found = false;
        Iterator<CoursePackage> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (id.equals(p.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            p.setName(name);
            p.setPrice(price);
            p.setNumLessons(numLessons);
        }
    }

    public static int getIDByName(String dName) {
        CoursePackage p;

        Iterator<CoursePackage> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (dName.trim().equals(p.getName().trim())) {
                return p.getID();
            }
        }
        return 0;
    }

    public static String getNameByID(int id) {
        CoursePackage p;

        Iterator<CoursePackage> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (id  == p.getID()) {
                return p.getName();
            }
        }
        return "";
    }

    public static void deletePackage(String pID) {
        CoursePackage p = null;
        boolean found = false;

        Iterator<CoursePackage> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (pID.equals(p.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            packages.remove(p);
        }
    }

    public static void listPackages() {
        CoursePackage p;
        Iterator<CoursePackage> itr = packages.iterator();
        System.out.printf("\n%-10s %-15s %-10s %-10s", "ID", "Name", "Price", "Lessons");

        Helpers.drawLine(Helpers.MEDIUM_LINE);

        while (itr.hasNext()) {
            p = itr.next();
            System.out.printf("\n%-10s %-15s %-10s %-10s", p.getID(), p.getName(), p.getPrice(), p.getNumLessons());
        }
        Helpers.drawLine(Helpers.MEDIUM_LINE);
    }
}
