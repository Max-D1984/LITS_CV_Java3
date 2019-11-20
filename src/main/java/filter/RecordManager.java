package filter;

import dto.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
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
                District myDistrict = getDistrict(line.get(1));
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

    }

    public Collection<Record> filterOnYear(LocalDate date) {
        return null;
    }

    public Collection<Record> filterOnMonth(LocalDate data) {
        return null;
    }

    public Collection<Record> filterOnDistrict(District district) {
        List<Record> districtFilter = new LinkedList();
        for (Record rec : recordList) {
            if (district.equals(rec.getRegion())) {
                districtFilter.add(rec);
            } else {
                continue;
            }
        }
        return districtFilter;
    }

    public Collection<Record> filterOnQuarter(int quarter) {
        List<Record> quarterFilter = new LinkedList<>();
        int start=0;
        int end=0;
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

    //метод вибору області
    private District getDistrict(String strDistrict) {
        District returnDistrict;

        switch (strDistrict) {
            case "Одеська":
                returnDistrict = District.ODESA_OBLAST;
                break;
            case "Дніпропетровська":
                returnDistrict = District.DNIPROPETROVSK_OBLAST;
                break;
            case "Чернігівська":
                returnDistrict = District.CHERNIHIV_OBLAST;
                break;
            case "Харківська":
                returnDistrict = District.KHARKIV_OBLAST;
                break;
            case "Житомирська":
                returnDistrict = District.ZHYTOMYR_OBLAST;
                break;
            case "Полтавська":
                returnDistrict = District.POLTAVA_OBLAST;
                break;
            case "Херсонська":
                returnDistrict = District.KHERSON_OBLAST;
                break;
            case "Київська":
                returnDistrict = District.KIEV_OBLAST;
                break;
            case "Запорізька":
                returnDistrict = District.ZAPORIZHIA_OBLAST;
                break;
            case "Луганська":
                returnDistrict = District.LUHANSK_OBLAST;
                break;
            case "Донецька":
                returnDistrict = District.DONETSK_OBLAST;
                break;
            case "Вінницька":
                returnDistrict = District.VINNYTSIA_OBLAST;
                break;
            case "Миколаївська":
                returnDistrict = District.MYKOLAIV_OBLAST;
                break;
            case "Кіровоградська":
                returnDistrict = District.KIROVOHRAD_OBLAST;
                break;
            case "Сумська":
                returnDistrict = District.SUMY_OBLAST;
                break;
            case "Львівська":
                returnDistrict = District.LVIV_OBLAST;
                break;
            case "Черкаська":
                returnDistrict = District.CHERKASY_OBLAST;
                break;
            case "Хмельницька":
                returnDistrict = District.KHMELNYTSKIY_OBLAST;
                break;
            case "Волинська":
                returnDistrict = District.VOLYN_OBLAST;
                break;
            case "Рівненська":
                returnDistrict = District.RIVNE_OBLAST;
                break;
            case "Івано-Франківська":
                returnDistrict = District.IVANO_FRANKIVSK_OBLAST;
                break;
            case "Тернопільська":
                returnDistrict = District.TERNOPIL_OBLAST;
                break;
            case "Закарпатська":
                returnDistrict = District.ZAKARPATTIA_OBLAST;
                break;
            case "Чернівецька":
                returnDistrict = District.CHERNIVTSY_OBLAST;
                break;
            case "Київ":
                returnDistrict = District.KIEV;
                break;
            case "АР Крим":
                returnDistrict = District.AR_KRYM;
                break;
            case "Севастополь":
                returnDistrict = District.SEVASTOPOL;
                break;
            default:
                System.out.println("Not correct district"); //------------------------------------------------
                returnDistrict = null;

        }
        return returnDistrict;
    }

}

