package com.drivingschool;

public class Helpers {
    public static final int SMALL_LINE = 30;
    public static final int MEDIUM_LINE = 70;
    public static final int LARGE_LINE = 110;

    public static void drawLine(int num) {
        String ln="";
        for (int i=0; i<num; i++) ln+="=";
        System.out.printf("\n"+ln);
    }

    public static void lineBreak(int num) {
        String format = "";
        for (int i=0; i<num; i++) format+="\n";

        System.out.printf(format);
    }
}
// parse LocalDate to a desired format
//        LocalDate date = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String text = date.format(formatter);
//        LocalDate parsedDate = LocalDate.parse(text, formatter);
//        System.out.println(parsedDate);

// parse string to LocalDate
//        String date = "2016-08-16";
//        LocalDate localDate = LocalDate.parse(date);
//        System.out.println(localDate);