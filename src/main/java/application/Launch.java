package main.java.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launch {


    public static List<Record> getFileLines(String fileName) {
        List<Record> recordList = new ArrayList<>();
        File myObj = new File(fileName);
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();


        switch (option) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
            default:
        }


        try {

            myReader.close();
        } catch () {
            System.out.println("An error occured.");
            return null;
        }
        return recordList;
    }
}
