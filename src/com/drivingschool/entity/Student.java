package com.drivingschool.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Student implements Serializable {
    private String ID;
    private String Name;
    private String Surname;
    private String Nationality;
    private LocalDate DOB;
    private String Status;
    private String LicenceType;
    private String LicenceExpire;
    private String LicenceNo;
    private LocalDate RegisterDate;



    public Student(String ID, String name, String surname, String nationality, LocalDate DOB, String status, LocalDate registerDate) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Nationality = nationality;
        this.DOB = DOB;
        Status = status;
        RegisterDate = registerDate;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public LocalDate getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
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

    public LocalDate getRegisterDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String text = RegisterDate.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        return parsedDate;
    }

}
