package drivingschool.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Student implements Serializable {

    private int ID;
    private String Name;
    private String Surname;
    private String Nationality;
    private String DOB;
    private String Status;
    private String LicenceType;
    private String LicenceExpire;
    private String LicenceNo;
    private String RegisterDate;

    public Student(int ID, String Name, String Surname, String Nationality, String DOB, String Status, String LicenceExpire, String LicenceNo, String RegisterDate) {
        this.ID = ID;
        this.Name = Name;
        this.Surname = Surname;
        this.Nationality = Nationality;
        this.DOB = DOB;
        this.Status = Status;
        this.LicenceExpire = LicenceExpire;
        this.LicenceNo = LicenceNo;
        this.RegisterDate = RegisterDate;
    }

    public Student(String Name, String Surname, String Nationality, String DOB, String Status, String LicenceExpire, String LicenceNo, String RegisterDate) {
        this.Name = Name;
        this.Surname = Surname;
        this.Nationality = Nationality;
        this.DOB = DOB;
        this.Status = Status;
        this.LicenceExpire = LicenceExpire;
        this.LicenceNo = LicenceNo;
        this.RegisterDate = RegisterDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getLicenceType() {
        return LicenceType;
    }

    public void setLicenceType(String LicenceType) {
        this.LicenceType = LicenceType;
    }

    public String getLicenceExpire() {
        return LicenceExpire;
    }

    public void setLicenceExpire(String LicenceExpire) {
        this.LicenceExpire = LicenceExpire;
    }

    public String getLicenceNo() {
        return LicenceNo;
    }

    public void setLicenceNo(String LicenceNo) {
        this.LicenceNo = LicenceNo;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(String RegisterDate) {
        this.RegisterDate = RegisterDate;
    }

}
