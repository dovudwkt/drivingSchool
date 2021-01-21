package drivingschool.entity;

//import java.util.String;

import java.io.Serializable;

public class Lesson implements Serializable {
    private int ID;
    private int PackageID;
    private int StudentID;
    private int LessonNo;
    private String LessonDate;
    private String StartTime;
    private String EndTime;
    private String Grade;

    public Lesson(int ID, int packageID, int studentID, int lessonNo, String lessonDate, String startTime, String endTime, String grade) {
        this.ID = ID;
        PackageID = packageID;
        StudentID = studentID;
        LessonNo = lessonNo;
        LessonDate = lessonDate;
        StartTime = startTime;
        EndTime = endTime;
        Grade = grade;
    }
     public Lesson(int packageID, int studentID, int lessonNo, String lessonDate, String startTime, String endTime, String grade) {
        PackageID = packageID;
        StudentID = studentID;
        LessonNo = lessonNo;
        LessonDate = lessonDate;
        StartTime = startTime;
        EndTime = endTime;
        Grade = grade;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPackageID() {
        return PackageID;
    }

    public void setPackageID(int packageID) {
        PackageID = packageID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getLessonNo() {
        return LessonNo;
    }

    public void setLessonNo(int lessonNo) {
        LessonNo = lessonNo;
    }

    public String getLessonDate() {
        return LessonDate;
    }

    public void setLessonDate(String lessonDate) {
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

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
}
