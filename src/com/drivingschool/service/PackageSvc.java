package com.drivingschool.service;

import java.util.List;
import com.drivingschool.entity.Package;

public class PackageSvc {
    public static List packages;

    public static void testPackage(){
        Package pkg = new Package("201", "Standard", 1500.0, 12);
        System.out.printf("\n%-10s %-15s %-10s %-10s", "ID", "Name", "Price", "lessons");
        System.out.printf("\n%-10s %-15s %-10s %-10s", pkg.getID(), pkg.getName(), pkg.getPrice(), pkg.getNumLessons());
    }
}
