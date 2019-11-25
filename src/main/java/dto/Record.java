package dto;

import filter.District;

import java.time.LocalDate;
import java.util.Objects;

/*
Даний клас містить у собі різні типи в одному класі (LocalDate, District, Integer).
Він дозволяє один раз провести перетворення файлу в один об'єкт та використовувати його в програмі
і в подальшому працювати з програмою ссилаючись на даний listRecord.
Він містить у собі конструктор Record, який говорить, що він хоче отримати на вхід LocalDate, District, Integer (число)
та записати дані у поля yearMonthDay, region, registrationCount.

equals - даний метод слугує для пошуку та порівняння двух однакових об'єктів.

Останні методи повертають записані зачення у yearMonthDay, region, registrationCount для подальшої роботи з ними.

 */
public class Record {

    private LocalDate yearMonthDay;
    private District region;
    private Integer registrationCount;

    public Record(LocalDate yearMonthDay, District region, Integer registrationCount) {
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
        return yearMonthDay + ", " + region + ", " + registrationCount;
    }
}
