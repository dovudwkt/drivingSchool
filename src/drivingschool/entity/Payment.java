package drivingschool.entity;

import java.io.Serializable;

public class Payment implements Serializable {
    private int ID;
    private int StudentID;
    private double Amount;
    private String Timestamp;
    private String Comment;

    public Payment(int ID, int StudentID, double Amount, String Timestamp, String Comment) {
        this.ID = ID;
        this.StudentID = StudentID;
        this.Amount = Amount;
        this.Timestamp = Timestamp;
        this.Comment = Comment;
    }

    public Payment(int StudentID, double Amount, String Timestamp, String Comment) {
        this.StudentID = StudentID;
        this.Amount = Amount;
        this.Timestamp = Timestamp;
        this.Comment = Comment;
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

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

}
