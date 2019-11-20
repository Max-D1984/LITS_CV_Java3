package dto;

import filter.District;

import java.time.LocalDate;

public class Record {

    private LocalDate yearMonthDay;
    private District region;
    private Integer registrationCount;

    public Record(LocalDate yearMonthDay, District region, Integer registrationCount){
        this.yearMonthDay = yearMonthDay;
        this.region = region;
        this.registrationCount = registrationCount;
    }

    public LocalDate getYearMonthDay() {
        return yearMonthDay;
    }

    public District getRegion() {
        return region;
    }

    public Integer getRegistrationCount() {
        return registrationCount;
    }


    @Override
    public String toString() {
        return "Record{" +
                "yearMonthDay=" + yearMonthDay +
                ", region=" + region +
                ", registrationCount=" + registrationCount +
                '}';
    }
}
