package application;


import dto.Record;
import filter.RecordManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launch {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String option = in.nextLine();
        RecordManager manager = new RecordManager();

        switch (option) {
            case "1":
              manager.filterOnYear (null);
                 break;

            case "2":
                break;

            case "3":
                break;

            case "4":
                break;

            case "5":
            default:
        }


    }
}
