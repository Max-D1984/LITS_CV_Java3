package filter;

import dto.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RecordManager {
    private List<Record> recordList = new LinkedList<>();

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

    public Collection<Record> filterOnYear(LocalDate localDate) {
        List<Record> yearFilter = new LinkedList<>();

        for (Record rec : recordList) {
            int y = localDate.getYear();
            if (rec.getYearMonthDay().getYear() == y) {
                yearFilter.add(rec);
            }

        }
        for (Record rec1: yearFilter){
            System.out.println(rec1.toString());
        }

        return yearFilter;
    }


    public Collection<Record> filterOnMonth(LocalDate data) {
        return null;
    }


    //метод фільтрації по областям, який повертає змінну типу Collection<Record>, в параметр отримує значення області district
    public Collection<Record> filterOnDistrict(District district) {
        //Створюємо колекцію, котра буде зберігати інформацію про ті реєстри, по чиїй області відбувається фільтрація
        List<Record> districtFilter = new LinkedList();
        //В циклі foreach проходимось по всіх значеннях реєстрів, на кожній ітерації зміння rec типу Record
        //приймає значення відповідної реєстрації
        for (Record rec : recordList) {
            //Умова виконання if:
            //якщо вказана нами область з клавіатури (District district) збігається із областю, яка вказується
            //в нашому rec на даній ітерації, тоді інформація про реєстрацію на даній інерації закинути в наш створений districtFilter;
            if (district.equals(rec.getRegion())) {
                districtFilter.add(rec);
                //інакше - пропустити цю ітерацію(нічого не виконувати і йти далі)
            } else {
                continue;
            }
        }
        //метод повертає заповнену колекцію districtFilter із відфільтрованими реєстрами по заданій області
        return districtFilter;
    }

    public Collection<Record> filterOnQuarter(int quarter) {
        List<Record> quarterFilter = new LinkedList<>();
        int start = 0;
        int end = 0;
        switch (quarter) {
            case 1:
                start = 1;
                end = 3;
                break;
            case 2:
                start = 4;
                end = 6;
                break;
            case 3:
                start = 7;
                end = 9;
                break;
            case 4:
                start = 10;
                end = 12;
                break;
        }
        for (Record rec : recordList
        ) {
            if (rec.getYearMonthDay().getMonthValue() >= start && rec.getYearMonthDay().getMonthValue() <= end) {
                quarterFilter.add(rec);
            }

        }
        return quarterFilter;
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
        FileWriter writer = null;

        try {
            //створюємо файл
            myFile.createNewFile();
            //задаємо writer'у працювати з нашим файлом
            writer = new FileWriter(myFile);
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
            //закриваємо файл
            writer.close();
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

