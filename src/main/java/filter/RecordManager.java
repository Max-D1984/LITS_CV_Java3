package filter;

import dto.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RecordManager {
    private List<Record> recordList = new LinkedList<>();

    public void readFile(String fileName) {
        File myFile = new File(fileName);
        Scanner myReader;
        try {
            boolean isFirst = true;
            myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                if (isFirst) {
                    isFirst = false;
                    myReader.nextLine();
                    continue;
                }

                //отримуємо стрічку, розбиваємої на складові, і заносимо всі поля в масив line
                List<String> line = getParsedString(myReader.nextLine());
                //перетворюємо стрічку в першому полі в формат (виклик методу getLocalDate() ) LocalDate і заносимо значення в змінну myDate
                LocalDate myDate = getLocalDate(line.get(0));
                //по другому полю вибираємо з перерахунку District область (виклик методу getDistrict()) і заносимо в змінну myDistrict
                District myDistrict = District.getDistrict(line.get(1));
                //третє поле перетворюємо із стрічки в int і заносимо в змінну myRegistrationCount
                int myRegistrationCount = Integer.parseInt(line.get(2));
                //створюємо новий запис (new Record) з нашими даними myDate, myDistrict, myRegistrationCount і заносимо в наш масив записів
                recordList.add(new Record(myDate, myDistrict, myRegistrationCount));

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
        }
    }

    public void printRecords(Collection<Record> records) {
        for (Record rec : records) {
            System.out.println(rec.toString());
        }
    }

    public Collection<Record> filterOnYear(LocalDate year) {
        List<Record> yearFilter = recordList.stream()
                .filter(y -> y.getYearMonthDay().getYear() == year.getYear())
                .collect(Collectors.toList());
        return yearFilter;
    }
    // метод фільтрації по місяцям.
         public Collection<Record> filterOnMonth(LocalDate month) {
    List<Record> monthFilter = recordList.stream()
            .filter(m -> m.getYearMonthDay().getMonthValue() == month.getMonthValue())
            .collect(Collectors.toList());
        return monthFilter;
}

    public Collection<Record> filterOnDistrict(Predicate<Record> districtPredicate) {
        List<Record> districtFilter = recordList.stream()
                .filter(districtPredicate)
                .collect(Collectors.toList());
        return districtFilter;
    }

    public Collection<Record> filterOnQuarter(int quarter) {
        int start = (quarter * 3) - 2;
        int end = start + 2;

        return recordList.stream()
                .filter(r -> r.getYearMonthDay().getMonthValue() >= start)
                .filter(r -> r.getYearMonthDay().getMonthValue() <= end)
                .collect(Collectors.toList());
    }

    //метод запису відфільтрованих значень у файл. Отримує на вхід колекцію Record
    public void recordsToFile(Collection<Record> recordCollection) {
        //форматер для перетворення LocalDateTime.now (теперішня дата і час) у формат "рік-місяць-день година-хвилини-секунди"
        //для створення унікальних назв файлів
        DateTimeFormatter formatterFileName = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        //форматер для перетворення LocalDate в Record e у формат "рік-місяць-день" для запису в стрічку
        DateTimeFormatter formatterYMD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //створюємо екземпляр класу File і одразу вносимо назву файлу який будемо створювати і записувати
        File myFile = new File(LocalDateTime.now().format(formatterFileName) + ".csv");
        //екземпляр класу FileWriter для запису в файл


        try (FileWriter writer = new FileWriter(myFile)) {
            //створюємо файл
            myFile.createNewFile();
            //змінна логічного типу для визначення чи перший запис для формування назв стовпчиків
            boolean isFirst = true;
            //змінна для визначення кінцевої стрічки для того щоб не ставити перевід каретки "n"
            int countLast = 0;
            //перебираємо всі Record в отриманій колекції
            for (Record rec : recordCollection
            ) {
                //якщо перша стрічка то записуємо назви стовпчиків
                if (isFirst) {
                    isFirst = false;
                    writer.write("month,region,vehicles_registered\n");
                }
                //якщо інші стрічки
                //переводимо значення дати з Record з формату LocalDate в String і записуємо в змінну date
                String date = rec.getYearMonthDay().format(formatterYMD);
                //переводимо значення region з Record з формату District в String і записуємо в змінну district
                String district = rec.getRegion().toString();
                //записуємо значення RegistrationCount з Record в змінну regCount
                int regCount = rec.getRegistrationCount();
                //записуємо отримані дані в файл
                writer.write(date + "," + district + "," + regCount);
                //перевіряємо чи це не крайня стрічка
                if (countLast++ != recordCollection.size() - 1) {
                    //якщо ні, то переводимо каретку (робимо абзац)
                    writer.write("\n");
                }
            }
            System.out.println("File was created");
        } catch (Exception ex) {
            System.out.println("Failed to write file");
        }

    }

    //---------------------------------------------------
    //-------------- Допоміжні методи -------------------
    //---------------------------------------------------

    //метод розбиття стрічки на складові
    private List<String> getParsedString(String str) {
        ArrayList<String> parseString = new ArrayList<>();
        for (String parseStr : str.split(",")
        ) {
            parseString.add(parseStr);
        }
        return parseString;
    }

    //метод перетворення стрічки в LocalDate
    private LocalDate getLocalDate(String strDate) {
        return LocalDate.parse(strDate);
    }


}

