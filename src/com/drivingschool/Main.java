package com.drivingschool;

import com.drivingschool.entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        String dateString = "01/08/1985";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = formatter.parse(dateString);
        Student student = new Student("177", "Dovud", "Inomov", "Tajik", dob, "New student",  new Date());

        System.out.printf("%10s %15s %15s %10s %10s %10s %10s",
                student.getID(),
                student.getName(),
                student.getSurname(),
                student.getNationality(),
                student.getDOB(),
                student.getStatus(),
                student.getRegisterDate());

    }
}
