package com.drivingschool;

import com.drivingschool.entity.Package;
import com.drivingschool.entity.Package;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PackageSvc {
    public static List packages;
    public static void main(String[] args) throws ParseException {
        packages = new ArrayList();
        testPackage();
        System.out.printf("\n");
    }
    public static void testPackage() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Package\n\n");
            System.out.printf("\n addPackage() ...\n");

            addPackage("201", "Standard", 1500.0, 12);
            addPackage("203", "Pro", 1800.0, 20);
            listPackages();

            System.out.printf("\n\n\n editPackage() where ID = 2 \n");
            editPackage("203","Pro",2000, 20);
            listPackages();

            System.out.printf("\n\n Backing up...\n");
            backupPackages();

            System.out.printf("\n deletePackage() whose std ID is 1\n");
            deletePackage("201");
            listPackages();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrievePackages();
            listPackages();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrievePackages() throws IOException, ClassNotFoundException
    {
        File infile  = new File("packages.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        packages = (ArrayList)inObjectStream.readObject();

        inObjectStream.close();

    }
    public static void backupPackages() throws IOException
    {
        File outfile  = new File("packages.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);

        outObjectStream.writeObject(packages);
        outObjectStream.close();

    }

    public static void addPackage(String id, String name, double price, int numLessons) {
        Package p= new Package(id, name, price, numLessons);
        packages.add(p);
    }

    public static void editPackage(String id, String name, double price, int numLessons) {
        Package p = null;
        boolean found = false;
        Iterator<Package> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(id.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) {
            p.setName(name);
            p.setPrice(price);
            p.setNumLessons(numLessons);
        }
    }

    public static void deletePackage(String pID) {
        Package p = null;
        boolean found = false;

        Iterator <Package> itr = packages.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(pID.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) packages.remove(p);
    }

    public static void listPackages() {
        Package p;
        Iterator <Package> itr = packages.iterator();
        System.out.printf("\n%-10s %-15s %-10s %-10s", "ID", "Name", "Price","Lessons");

        Helpers.drawLine(Helpers.LARGE_LINE);

        while (itr.hasNext()) {
            p = itr.next();
            System.out.printf("\n%-10s %-15s %-10s %-10s", p.getID(), p.getName(), p.getPrice(), p.getNumLessons());
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }
}
