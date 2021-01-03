package com.drivingschool.entity;

import java.util.Date;

public class Student {
    private String ID;
    private String Name;
    private String Surname;
    private String Nationality;
    private Date DOB;
    private String Status;
    private String LicenceType;
    private String LicenceExpire;
    private String LicenceNo;
    private Date RegisterDate;

    public Student(String ID, String name, String surname, String nationality, Date DOB, String status, Date registerDate) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Nationality = nationality;
        this.DOB = DOB;
        Status = status;
        RegisterDate = registerDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getLicenceType() {
        return LicenceType;
    }

    public void setLicenceType(String licenceType) {
        LicenceType = licenceType;
    }

    public String getLicenceExpire() {
        return LicenceExpire;
    }

    public void setLicenceExpire(String licenceExpire) {
        LicenceExpire = licenceExpire;
    }

    public String getLicenceNo() {
        return LicenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        LicenceNo = licenceNo;
    }

    public Date getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(Date registerDate) {
        RegisterDate = registerDate;
    }
}
