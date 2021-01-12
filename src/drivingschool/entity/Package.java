package drivingschool.entity;

import java.io.Serializable;

public class Package implements Serializable {
    private String ID;
    private String Name;
    private double Price;
    private int NumLessons;

    public Package(String ID, String name, double price, int numLessons) {
        this.ID = ID;
        Name = name;
        Price = price;
        NumLessons = numLessons;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getNumLessons() {
        return NumLessons;
    }

    public void setNumLessons(int numLessons) {
        NumLessons = numLessons;
    }
}
