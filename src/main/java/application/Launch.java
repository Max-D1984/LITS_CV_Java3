package application;


import dto.Record;
import filter.District;
import filter.RecordManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

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

        int first;
        System.out.println("Your option are: ");
        System.out.println("1 - filter on Year;");
        System.out.println("2 - filter on Month;");
        System.out.println("3 - filter on District;");
        System.out.println("4 - filter on Quarter.");
        System.out.println("Choose the filter: ");

        try {
            first = in.nextInt();
            switch (first) {
                case 1:
                    System.out.println("You did select the filter on Year!");
                    System.out.println("Please enter Year:");
                    filterOnYear(in.nextLine());
                    break;
                case 2:
                    System.out.println("You did select the filter on Month!");
                    System.out.println("Please enter Month:");
                    filterOnMonth(in.nextLine());
                    break;

                case 3:
                    System.out.println("You did select the filter on District");
                    System.out.println("Please enter District:");
                    filterOnDistrict(in.nextLine());
                    break;

                case 4:
                    System.out.println("You did select the filter on Quarter");
                    break;

                case 0:
                    goOnAsking = false;
                    System.out.println("Thanks for using our program!");
                    break;
                default:
                    System.out.println("Incorrect number of option!");
                    System.out.println();

            }
        }catch(InputMismatchException ex){
            System.out.println("You need to input numerical value");
            System.out.println();
        }




    }
    private static void filterOnMonth(String enteredMonth) {

        System.out.println("selected Month " + enteredMonth);
        int month = Integer.parseInt(enteredMonth);
        LocalDate localDate =  LocalDate.of( 0,month, 1);
        Collection<Record> records = recordManager.filterOnMonth(localDate);
        recordManager.printRecords(records);
    }

    private static void filterOnYear(String enteredYear) {

        System.out.println("Selected Year " + enteredYear);
        int year = Integer.parseInt(enteredYear);
        LocalDate localDate =  LocalDate.of( year ,1, 1);
        Collection<Record> records = recordManager.filterOnYear(localDate);
        recordManager.printRecords(records);
    }

    private static void filterOnDistrict(String districtName){
        System.out.println("Selected District " + districtName);
        Collection<Record> records = recordManager.filterOnDistrict(District.getDistrict(districtName));
        recordManager.printRecords(records);
    }

}
