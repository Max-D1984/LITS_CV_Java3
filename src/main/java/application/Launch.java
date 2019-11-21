package application;


import dto.Record;
import filter.District;
import filter.RecordManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launch {


    public static void main(String[] args) {
        String first = "";
        Scanner in = new Scanner(System.in);
        while (!first.equals("0")) {
            System.out.println("Choose the filter: ");
            first = in.nextLine();
            switch (first) {
                case "1":
                    System.out.println("You did select the filter on Year!");
                    System.out.println("Please enter Year:");
                    filterOnYear(in.nextLine());
                    break;
                case "2":
                    System.out.println("You did select the filter on Month!");
                    break;

                case "3":
                    System.out.println("You did select the filter on District");
                    break;

                case "4":
                    System.out.println("You did select the filter on Quarter");
                    break;

                case "0":
                    System.out.println("Good Bye ");
                    break;
            }
            //System.out.println(first);
        }



   /*     String option = in.nextLine();
        RecordManager manager = new RecordManager();

        switch (option) {
            case "1":
                 break;

            case "2":
                break;

            case "3":
                break;

            case "4":
                break;

            case "5":
            default:
        } */


    }

    private static void filterOnYear(String enteredYear) {

        System.out.println("selected Year " + enteredYear);


    }


}
