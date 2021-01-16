package drivingschool.repo;

import drivingschool.entity.Lesson;
import drivingschool.entity.CoursePackage;
import drivingschool.entity.Student;
import drivingschool.Helpers;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LessonRepo {

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

            addLesson("845", "1201", "116229", 1, "2021-01-05", "10:00", "10:40", 90);
            addLesson("846", "1201", "116229", 2, "2021-01-06", "10:00", "11:00", 0);
            addLesson("891", "1204", "168337", 5, "2021-01-10", "14:30", "15:10", 74);

            listLessons();
            System.out.printf("\n\n\n editLesson() Edit grade of second lesson to 89 where id is 846 and student is Ali Faisal   \n");
            editLesson("846", "1201", "116229", 2, "2021-01-06", "10:00", "11:00", 89);

            listLessons();
            System.out.printf("\n\n Backing up...\n");
            backupLessons();

            System.out.printf("\n deleteLesson() Cancel lesson with id 891\n");
            deleteLesson("891");
            listLessons();

            System.out.printf("\n\n\n Retrieving backed up data...\n");
            retrieveLessons();
//            listLessons();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LessonRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void populateData() throws IOException, ClassNotFoundException {
        addLesson("845", "1201", "116229", 1, "2021-01-05", "10:00", "10:40", 90);
        addLesson("846", "1201", "116229", 2, "2021-01-06", "10:00", "11:00", 0);
        addLesson("891", "1204", "168337", 5, "2021-01-10", "14:30", "15:10", 74);
        backupLessons();
    }

    public static void retrieveLessons() throws IOException, ClassNotFoundException {
        lessons = Helpers.readFile("backups/lessons.dat");
    }

    public static void backupLessons() throws IOException {
        Helpers.writeFile(lessons, "backups/lessons.dat");
    }

    public static void addLesson(String id, String pkgID, String stdID, int lessonNo, String date, String startTime, String endtTime, int grade) {
        Lesson p = new Lesson(id, pkgID, stdID, lessonNo, LocalDate.parse(date), startTime, endtTime, grade);
        lessons.add(p);
    }

    public static void editLesson(String id, String pkgID, String stdID, int lessonNo, String date, String startTime, String endtTime, int grade) {
        Lesson p = null;
        boolean found = false;
        Iterator<Lesson> itr = lessons.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (id.equals(p.getID())) {
                found = true;
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

        Iterator<Lesson> itr = lessons.iterator();
        while (itr.hasNext()) {
            p = itr.next();
            if (ID.equals(p.getID())) {
                found = true;
                break;
            }
        }
        if (found) {
            lessons.remove(p);
        }
    }

    public static void listLessons() throws IOException, ClassNotFoundException {
        Lesson lesson;
        Student student;
        CoursePackage pkg;

        List students = Helpers.readFile("backups/students.dat");
        List packages = Helpers.readFile("backups/packages.dat");

        System.out.printf("\n%-10s %-12s %-15s %-10s %-10s %-8s %-15s %-22s", "ID", "Lessons No", "Date", "Start Time", "End Time", "Grade", "CoursePackage", "Student Name");
        Helpers.drawLine(Helpers.LARGE_LINE);

        Iterator<Lesson> lessonsItr = lessons.iterator();
        while (lessonsItr.hasNext()) {
            lesson = lessonsItr.next();

            System.out.printf("\n%-10s %-12s %-15s %-10s %-10s %-8s ",
                    lesson.getID(),
                    lesson.getLessonNo(),
                    lesson.getLessonDate(),
                    lesson.getStartTime(),
                    lesson.getEndTime(),
                    lesson.getGrade());

            Iterator<CoursePackage> packagesItr = packages.iterator();
            while (packagesItr.hasNext()) {
                pkg = packagesItr.next();
                if (pkg.getID().equals(lesson.getPackageID())) {
                    System.out.printf("%-15s ", pkg.getName());
                    break;
                }
            }

            Iterator<Student> studentsItr = students.iterator();
            while (studentsItr.hasNext()) {
                student = studentsItr.next();
                if (student.getID().equals(lesson.getStudentID())) {
                    System.out.print(student.getName() + " " + student.getSurname());
                    break;
                }
            }
        }
        Helpers.drawLine(Helpers.LARGE_LINE);
    }

}
