package filter;

import dto.Record;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public enum FileEnum {
    FILTER_ON_YEAR("isYear"),
    FILTER_ON_MONTH("isMonth"),
    FILTER_ON_DISTRICT("isDistrict"),
    FILTER_ON_QUARTER("isQuarter");

    private String method;
    RecordManager recordManager;
    FileEnum(String method){
        this.method = method;
    }

public void filtration(RecordManager recManager){
        this.recordManager = recManager;
    switch (method){
        case "isYear":
            isYear();
            break;
        case "isMonth":
            isMonth();
            break;
        case "isDistrict":
            isDistrict();
            break;
        case "isQuarter":
            isQuarter();
            break;
    }
}


    //----------------------------------------------------------//
    //--------Методи виклику фільтрів---------------------------//
    //----------------------------------------------------------//

    private  void filterOnMonth(String enteredMonth) {
        System.out.println("selected Month " + enteredMonth);
        int month = Integer.parseInt(enteredMonth);
        LocalDate localDate = LocalDate.of(0, month, 1);
        Collection<Record> records = recordManager.filterOnMonth(localDate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private  void filterOnQuarter(String enteredQuarter) {
        System.out.println("Selected Quarter " + enteredQuarter);
        int quarter = Integer.parseInt(enteredQuarter);
        Collection<Record> records = recordManager.filterOnQuarter(quarter);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private  void filterOnYear(String enteredYear) {

        System.out.println("Selected Year " + enteredYear);
        int year = Integer.parseInt(enteredYear);
        LocalDate localDate = LocalDate.of(year, 1, 1);
        Collection<Record> records = recordManager.filterOnYear(localDate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private  void filterOnDistrict(String districtName) {
        System.out.println("Selected District " + districtName);
        Collection<Record> records = recordManager.filterOnDistrict(District.getDistrict(districtName));
        recordManager.printRecords(records);
        printTOFile(records);
    }

    //----------------------------------------------------------//
    //------------Виклик методу друкування в файл---------------//
    //----------------------------------------------------------//

    private  void printTOFile(Collection<Record> records) {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to write into a file? (y/n)");
        if (in.nextLine().equals("y")) {
            System.out.println("strat to creating a file");
            recordManager.recordsToFile(records);
        }
    }


    //----------------------------------------------------------//
    //--------Виклик методів перевірки введених даних-----------//
    //----------------------------------------------------------//

    private  void isDistrict() {
        Scanner in = new Scanner(System.in);
        boolean checkDistrict = false;
        String strDistrict;
        while (!checkDistrict) {
            strDistrict = in.nextLine();
            if (strDistrict.equals("0")) {
                checkDistrict = true;
            } else {
                for (District dist : District.values()) {
                    if (strDistrict.equals(dist.getName())) {
                        checkDistrict = true;
                        break;
                    }
                }
                if (checkDistrict) {
                    System.out.println("You did select the next district " + strDistrict);
                    filterOnDistrict(strDistrict);
                    break;
                } else {
                    System.out.println("You input wrong name of District. please repeat or enter 0 to exit:");
                }
            }
        }
    }

    private  void isMonth() {
        Scanner in = new Scanner(System.in);
        String[] numberOfMonth = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String strMonth;
        boolean checkMonth = false;
        while (!checkMonth) {
            strMonth = in.nextLine();
            if (strMonth.equals("0")) {
                checkMonth = true;
            } else {
                for (String month : numberOfMonth) {
                    if (strMonth.equals(month)) {
                        checkMonth = true;
                        break;
                    }
                }
                if (checkMonth) {
                    System.out.println("You did select the next month " + strMonth);
                    filterOnMonth(strMonth);
                    checkMonth = true;
                } else {
                    System.out.println("You did select wrong type of month, " +
                            "please try again or entered 0 for exit: ");
                }
            }
        }
    }

    private  void isYear() {
        Scanner in = new Scanner(System.in);
        String[] numberOfYear = {"2013", "2014", "2015", "2016", "2017", "2018", "2019"};
        String strYear;
        boolean checkYear = false;
        while (!checkYear) {
            strYear = in.nextLine();
            if (strYear.equals("0")) {
                checkYear = true;
            } else {
                for (String year : numberOfYear) {
                    if (strYear.equals(year)) {
                        checkYear = true;
                        break;
                    }
                }
                if (checkYear) {
                    System.out.println("You did select the next year: " + strYear);
                    filterOnYear(strYear);
                } else {
                    System.out.println("You did select wrong year, " +
                            "please try again or entered 0 for exit: ");
                }
            }
        }
    }


    private  void isQuarter() {
        Scanner in = new Scanner(System.in);
        boolean quarterCheck = false;
        String strQuarter;
        while (!quarterCheck) {
            strQuarter = in.nextLine();
            if (strQuarter.equals("1") || strQuarter.equals("2") || strQuarter.equals("3") || strQuarter.equals("4")) {
                filterOnQuarter(strQuarter);
                quarterCheck = true;
            } else if (strQuarter.equals("0")) {
                quarterCheck = true;
            } else {
                System.out.println("You input wrong quarter. please repeat or input 0 to go back:");
            }

        }
    }

}
