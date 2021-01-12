package drivingschool.entity;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {
    private String ID;
    private String StudentID;
    private double Amount;
    private Date Timestamp;
    private String Comment;

    public Payment(String ID, String studentID, double amount, Date timestamp, String comment) {
        this.ID = ID;
        StudentID = studentID;
        Amount = amount;
        Timestamp = timestamp;
        Comment = comment;
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

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date timestamp) {
        Timestamp = timestamp;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
