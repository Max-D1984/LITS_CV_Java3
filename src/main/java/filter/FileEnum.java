package filter;

import dto.Record;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;
import java.util.function.Predicate;

public enum FileEnum {
    FILTER_ON_YEAR("isYear"),
    FILTER_ON_MONTH("isMonth"),
    FILTER_ON_DISTRICT("isDistrict"),
    FILTER_ON_QUARTER("isQuarter");

    RecordManager recordManager;
    private String method;
    private String inputDistrict;
    private LocalDate localDate;
    private int startMonth;
    private int endMonth;

    Predicate<Record> quarterPredicate = r -> r.getYearMonthDay().getMonthValue() >= startMonth && r.getYearMonthDay().getMonthValue() <= endMonth;
    Predicate<Record> districtPredicate = x -> x.getRegion().equals(District.getDistrict(inputDistrict));
    Predicate<Record> yearPredicate = y -> y.getYearMonthDay().getYear() == localDate.getYear();

    FileEnum(String method) {
        this.method = method;
    }

    public void setInputDistrict(String inputDistrict) {
        this.inputDistrict = inputDistrict;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setStartEndMonth(int start, int end) {
        this.startMonth = start;
        this.endMonth = end;
    }


    public void filtration(RecordManager recManager) {
        this.recordManager = recManager;
        switch (method) {
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

    private void filterOnMonth(String enteredMonth) {
        System.out.println("selected Month " + enteredMonth);
        int month = Integer.parseInt(enteredMonth);
        LocalDate localDate = LocalDate.of(0, month, 1);
        Collection<Record> records = recordManager.filterOnMonth(localDate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private void filterOnQuarter(String enteredQuarter, Predicate<Record> quarterPredicate) {
        System.out.println("Selected Quarter " + enteredQuarter);
        Collection<Record> records = recordManager.filterOnQuarter(quarterPredicate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private void filterOnYear(String enteredYear, Predicate<Record> yearPredicate) {

        System.out.println("Selected Year " + enteredYear);
        int year = Integer.parseInt(enteredYear);
        LocalDate localDate = LocalDate.of(year, 1, 1);
        Collection<Record> records = recordManager.filterOnYear(yearPredicate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    private void filterOnDistrict(String districtName, Predicate<Record> districtPredicate) {
        System.out.println("Selected District " + districtName);
        Collection<Record> records = recordManager.filterOnDistrict(districtPredicate);
        recordManager.printRecords(records);
        printTOFile(records);
    }

    //----------------------------------------------------------//
    //------------Виклик методу друкування в файл---------------//
    //----------------------------------------------------------//

    private void printTOFile(Collection<Record> records) {
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

    private void isDistrict() {
        Scanner in = new Scanner(System.in);
        boolean checkDistrict = false;

        while (!checkDistrict) {
            setInputDistrict(in.nextLine());
            if (inputDistrict.equals("0")) {
                checkDistrict = true;
            } else {
                for (District dist : District.values()) {
                    if (inputDistrict.equals(dist.getName())) {
                        checkDistrict = true;
                        break;
                    }
                }
                if (checkDistrict) {
                    System.out.println("You did select the next district " + inputDistrict);
                    filterOnDistrict(inputDistrict, districtPredicate);
                    break;
                } else {
                    System.out.println("You input wrong name of District. please repeat or enter 0 to exit:");
                }
            }
        }
    }

    private void isMonth() {
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




    private void isYear() {
        Scanner in = new Scanner(System.in);
        String[] numberOfYear = {"2013", "2014", "2015", "2016", "2017", "2018", "2019"};
        String strYear;
        boolean checkYear = false;
        while (!checkYear) {
            strYear = in.nextLine();
         setLocalDate(LocalDate.of(Integer.parseInt(strYear), 1, 1));

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

                    filterOnYear(strYear, yearPredicate);
                } else {
                    System.out.println("You did select wrong year, " +
                            "please try again or entered 0 for exit: ");
                }
            }
        }
    }


    private void isQuarter() {
        Scanner in = new Scanner(System.in);
        boolean quarterCheck = false;
        String strQuarter;
        while (!quarterCheck) {
            strQuarter = in.nextLine();
            if (strQuarter.equals("1") || strQuarter.equals("2") || strQuarter.equals("3") || strQuarter.equals("4")) {
                setStartEndMonth((Integer.parseInt(strQuarter) * 3) - 2, ((Integer.parseInt(strQuarter) * 3) - 2) + 2);

                filterOnQuarter(strQuarter, quarterPredicate);
                quarterCheck = true;
            } else if (strQuarter.equals("0")) {
                quarterCheck = true;
            } else {
                System.out.println("You input wrong quarter. please repeat or input 0 to go back:");
            }

        }
    }

}
