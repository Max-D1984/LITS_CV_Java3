package filter;

import dto.Record;

import dto.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RecordManager {
    private List<Record> recordList;

    public void readFile(String fileName) {
        File myFile = new File(fileName);
        Scanner myReader = null;
        try {
            boolean isFirst = true;
            myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                if (isFirst) {
                    isFirst = false;
                    myReader.nextLine();
                    continue;
                }
                String line = myReader.nextLine();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
        }
    }

    public void printRecords(Collection<Record> records) {

    }

   public Collection<Record> filterOnYear(LocalDate date) { return null;}

   public Collection<Record> filterOnMonth(LocalDate data) {
        return null;
    }

   public Collection<Record> filterOnDistrict(LocalDate data) {
        return null;
    }

   public Collection<Record> filterOnQuarter(LocalDate data) {
        return null;
    }
}
