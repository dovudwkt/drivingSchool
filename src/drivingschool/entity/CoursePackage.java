package drivingschool.entity;

import java.io.Serializable;

public class CoursePackage implements Serializable {
    private int ID;
    private String Name;
    private double Price;
    private int NumLessons;

    public CoursePackage(String Name, double Price, int NumLessons) {
        this.Name = Name;
        this.Price = Price;
        this.NumLessons = NumLessons;
    }

    public CoursePackage(int ID, String name, double price, int numLessons) {
        this.ID = ID;
        Name = name;
        Price = price;
        NumLessons = numLessons;
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
