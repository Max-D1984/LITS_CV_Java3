package application;


import dto.Record;
import filter.District;
import filter.RecordManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Launch {
    private static boolean goOnAsking = true;
    static RecordManager recordManager = new RecordManager();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        recordManager.readFile("data.csv");
        while (goOnAsking) {
            defineFilters(in);
        }



    }

    private static void defineFilters(Scanner in) {

        String first;
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
                System.out.println("Please enter Month:");
                filterOnMonth(in.nextLine());
                break;

            case "3":
                System.out.println("You did select the filter on District");
                System.out.println("Please enter District:");
                filterOnDistrict(in.nextLine());
                break;

            case "4":
                System.out.println("You did select the filter on Quarter");
                break;

            case "0":
                goOnAsking = false;
                System.out.println("Thanks for using our program");
                break;
        }

    }
    private static void filterOnMonth(String enteredMonth) {

        System.out.println("selected Month " + enteredMonth);
    }

    private static void filterOnYear(String enteredYear) {

        System.out.println("Selected Year " + enteredYear);
    }
    private static void filterOnDistrict(String districtName){
        System.out.println("Selected District " + districtName);
        Collection<Record> records = recordManager.filterOnDistrict(District.getDistrict(districtName));
        recordManager.printRecords(records);
    }

}
