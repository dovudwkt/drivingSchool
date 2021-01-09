package com.drivingschool.service;

import java.time.LocalDate;
import java.util.List;
import com.drivingschool.entity.Lesson;

public class LessonSvc {
    public static List lessons;

    public static void testLesson(){
        Lesson lesson = new Lesson("1", "201", "17701937",1, LocalDate.now(), "8:30", "10:00",90);

        System.out.printf("\n%-10s %-15s %-12s %-12s %-15s %-10s %-10s %-4s", "ID", "Package ID", "Student ID", "Lessons No", "Date", "Start Time", "End Time", "Grade");
        System.out.printf("\n%-10s %-15s %-12s %-12s %-15s %-10s %-10s %-4s",
                lesson.getID(),
                lesson.getPackageID(),
                lesson.getStudentID(),
                lesson.getLessonNo(),
                lesson.getLessonDate(),
                lesson.getStartTime(),
                lesson.getEndTime(),
                lesson.getGrade());
    }
}
