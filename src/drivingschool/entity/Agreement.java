package drivingschool.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Agreement implements Serializable {
    private String ID;
    private String StudentID;
    private String PackageID;
    private LocalDate StartDate;

    public Agreement(String ID, String studentID, String packageID, LocalDate startDate) {
        this.ID = ID;
        StudentID = studentID;
        PackageID = packageID;
        StartDate = startDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getPackageID() {
        return PackageID;
    }

    public void setPackageID(String packageID) {
        PackageID = packageID;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }
}
