package dto;

import filter.District;

import java.time.LocalDate;
import java.util.Objects;

public class Record {

    private LocalDate yearMonthDay;
    private District region;
    private Integer registrationCount;

    public Record(LocalDate yearMonthDay, District region, Integer registrationCount){
        this.yearMonthDay = yearMonthDay;
        this.region = region;
        this.registrationCount = registrationCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return yearMonthDay.equals(record.yearMonthDay) &&
                region == record.region &&
                registrationCount.equals(record.registrationCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearMonthDay, region, registrationCount);
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
        return  yearMonthDay + ", " + region + ", " + registrationCount;
    }
}
