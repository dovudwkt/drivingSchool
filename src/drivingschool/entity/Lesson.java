package drivingschool.entity;

//import java.util.LocalDate;

import java.io.Serializable;
import java.time.LocalDate;

public class Lesson implements Serializable {
    private String ID;
    private String PackageID;
    private String StudentID;
    private int LessonNo;
    private LocalDate LessonDate;
    private String StartTime;
    private String EndTime;
    private int Grade;

    public Lesson(String ID, String packageID, String studentID, int lessonNo, LocalDate lessonDate, String startTime, String endTime, int grade) {
        this.ID = ID;
        PackageID = packageID;
        StudentID = studentID;
        LessonNo = lessonNo;
        LessonDate = lessonDate;
        StartTime = startTime;
        EndTime = endTime;
        Grade = grade;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPackageID() {
        return PackageID;
    }

    public void setPackageID(String packageID) {
        PackageID = packageID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getLessonNo() {
        return LessonNo;
    }

    public void setLessonNo(int lessonNo) {
        LessonNo = lessonNo;
    }

    public LocalDate getLessonDate() {
        return LessonDate;
    }

    public void setLessonDate(LocalDate lessonDate) {
        LessonDate = lessonDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }
}
