package drivingschool.entity;

import java.io.Serializable;

public class Agreement implements Serializable {
    private int ID;
    private int StudentID;
    private int PackageID;
    private String StartDate;

    public Agreement(int ID, int StudentID, int PackageID, String StartDate) {
        this.ID = ID;
        this.StudentID = StudentID;
        this.PackageID = PackageID;
        this.StartDate = StartDate;
    }

    public Agreement(int StudentID, int PackageID, String StartDate) {
        this.StudentID = StudentID;
        this.PackageID = PackageID;
        this.StartDate = StartDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getPackageID() {
        return PackageID;
    }

    public void setPackageID(int PackageID) {
        this.PackageID = PackageID;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

}
