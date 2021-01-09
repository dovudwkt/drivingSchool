package com.drivingschool;

import com.drivingschool.entity.Lesson;
import com.drivingschool.entity.Lesson;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LessonSvc {
    public static List lessons;


    public static void main(String[] args) throws ParseException {
        lessons = new ArrayList();
        testLesson();
        System.out.printf("\n");
    }
    public static void testLesson() throws ParseException {
        try {
            System.out.printf("\n Tests for Class Lesson\n\n");
            System.out.printf("\n addLesson() ...\n");

            addLesson("1", "201", "17701937",1, "2021-01-09", "8:30", "10:00",0);

            listLessons();

            System.out.printf("\n\n\n editLesson() where ID = 2 \n");
            editLesson("1", "201", "17701937",1, "2021-01-09", "8:30", "10:00",90);
            listLessons();

            System.out.printf("\n\n Backing up...\n");
            backupLessons();

            System.out.printf("\n deleteLesson() whose std ID is 1\n");
            deleteLesson("1");
            listLessons();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveLessons();
            listLessons();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }


    public static void retrieveLessons() throws IOException, ClassNotFoundException
    {
        File infile  = new File("lessons.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        lessons = (ArrayList)inObjectStream.readObject();

        inObjectStream.close();

    }
    public static void backupLessons() throws IOException
    {
        File outfile  = new File("lessons.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);

        outObjectStream.writeObject(lessons);
        outObjectStream.close();

    }

    public static void addLesson(String id, String pkgID, String stdID, int lessonNo, String date, String startTime, String endtTime, int grade) {
        Lesson p= new Lesson(id, pkgID,stdID, lessonNo, LocalDate.parse(date), startTime, endtTime, grade);
        lessons.add(p);
    }

    public static void editLesson(String id, String pkgID, String stdID, int lessonNo, String date, String startTime, String endtTime, int grade) {
        Lesson p = null;
        boolean found = false;
        Iterator<Lesson> itr = lessons.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(id.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) {
            p.setStudentID(stdID);
            p.setLessonNo(lessonNo);
            p.setLessonDate(LocalDate.parse(date));
            p.setStartTime(startTime);
            p.setEndTime(endtTime);
            p.setGrade(grade);
        }
    }

    public static void deleteLesson(String ID) {
        Lesson p = null;
        boolean found = false;

        Iterator <Lesson> itr = lessons.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if(ID.equals(p.getID())) {
                found=true;
                break;
            }
        }
        if (found) lessons.remove(p);
    }

    public static void listLessons() {
        Lesson l;
        Iterator <Lesson> itr = lessons.iterator();
        System.out.printf("\n%-10s %-15s %-12s %-12s %-15s %-10s %-10s %-4s", "ID", "Package ID", "Student ID", "Lessons No", "Date", "Start Time", "End Time", "Grade");
        Helpers.drawLine(Helpers.LARGE_LINE);

        while (itr.hasNext()) {
            l = itr.next();
            System.out.printf("\n%-10s %-15s %-12s %-12s %-15s %-10s %-10s %-4s",
                    l.getID(),
                    l.getPackageID(),
                    l.getStudentID(),
                    l.getLessonNo(),
                    l.getLessonDate(),
                    l.getStartTime(),
                    l.getEndTime(),
                    l.getGrade());

        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }

}
