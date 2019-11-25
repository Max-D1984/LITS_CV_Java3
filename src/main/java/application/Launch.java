package application;

import filter.FileEnum;
import filter.RecordManager;

import java.util.*;

public class Launch {
    private static boolean goOnAsking = true;
    private static FileEnum filtr;
    private static RecordManager recordManager = new RecordManager();

    public static void main(String[] args) {
        recordManager.readFile("data.csv");
        while (goOnAsking) {
            defineFilters();
        }


    }

    private static void defineFilters() {
        Scanner sc = new Scanner(System.in);
        int first;
        System.out.println("Your option are: ");
        System.out.println("1 - filter on Year;");
        System.out.println("2 - filter on Month;");
        System.out.println("3 - filter on District;");
        System.out.println("4 - filter on Quarter;");
        System.out.println("0 - exit the program.");
        System.out.println("Choose the filter: ");

        try {
            first = sc.nextInt();
            switch (first) {
                case 1:
                    System.out.println("You did select the filter on Year!");
                    System.out.println("Please enter Year:");
                    filtr = FileEnum.FILTER_ON_YEAR;
                    filtr.filtration(recordManager);
                    break;
                case 2:
                    System.out.println("You did select the filter on Month!");
                    System.out.println("Please enter Month:");
                    filtr = FileEnum.FILTER_ON_MONTH;
                    filtr.filtration(recordManager);
                    break;
                case 3:
                    System.out.println("You did select the filter on District");
                    System.out.println("Please enter District:");
                    filtr = FileEnum.FILTER_ON_DISTRICT;
                    filtr.filtration(recordManager);
                    break;
                case 4:
                    System.out.println("You did select the filter on Quarter");
                    System.out.println("Please enter Quartet(1, 2, 3, 4):");
                    filtr = FileEnum.FILTER_ON_QUARTER;
                    filtr.filtration(recordManager);
                    break;
                case 0:
                    goOnAsking = false;
                    System.out.println("Thanks for using our program!");
                    break;
                default:
                    System.out.println("Incorrect number of option!");
                    System.out.println();
            }
        } catch (InputMismatchException ex) {
            System.out.println("You need to input numerical value");
            System.out.println();
        }
    }


}
