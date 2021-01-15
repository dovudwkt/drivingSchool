package drivingschool;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static final int SMALL_LINE = 30;
    public static final int MEDIUM_LINE = 70;
    public static final int LARGE_LINE = 110;
    public static final int EXTRA_LARGE_LINE = 150;

    public static void drawLine(int num) {
        String ln = "";
        for (int i = 0; i < num; i++) {
            ln += "=";
        }
        System.out.printf("\n" + ln);
    }

    public static void lineBreak(int num) {
        String format = "";
        for (int i = 0; i < num; i++) {
            format += "\n";
        }

        System.out.printf(format);
    }

    public static List readFile(String path) throws IOException, ClassNotFoundException {
        File inFile = new File(path);
        FileInputStream inFileStram = new FileInputStream(inFile);
        ObjectInputStream inObjStram = new ObjectInputStream(inFileStram);
        List data = (ArrayList) inObjStram.readObject();
        inObjStram.close();

        return data;
    }

    public static void writeFile(List obj, String path) throws IOException {
        File outfile = new File(path);
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
        outObjectStream.writeObject(obj);
        outObjectStream.close();
    }

//    public static String LocalDateToString(LocalDate date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String text = date.format(formatter);
//        LocalDate parsedDate = LocalDate.parse(text, formatter);
//        return parsedDate;
//    }

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
