package filter;

import main.java.dto.Record;

import main.java.dto.Record;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class RecordManager<list> {
    private List<Record> recordList;

    public void readFile(String fileName) {

    }

    public void printRecords(Collection<Record> records) {

    }

    Collection<Record> filterOnYear(LocalDate date) {


        List<Record>rez=new LinkedList();
        for(Record record:recordList){
            record.getYearMonth().getYear();

        }

        return rez;


    }

    Collection<Record> filterOnMonth(LocalDate data) {
        return null;
    }

    Collection<Record> filterOnDistrict(LocalDate data) {
        return null;
    }

    Collection<Record> filterOnQuarter(LocalDate data) {
        return null;
    }
}
