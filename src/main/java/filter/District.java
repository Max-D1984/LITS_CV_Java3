package filter;

public enum District {
    ODESA_OBLAST("Одеська"),
    DNIPROPETROVSK_OBLAST("Дніпропетровська"),
    CHERNIHIV_OBLAST("Чернігівська"),
    KHARKIV_OBLAST("Харківська"),
    ZHYTOMYR_OBLAST("Житомирська"),
    POLTAVA_OBLAST("Полтавська"),
    KHERSON_OBLAST("Херсонська"),
    KIEV_OBLAST("Київська"),
    ZAPORIZHIA_OBLAST("Запорізька"),
    LUHANSK_OBLAST("Луганська"),
    DONETSK_OBLAST("Донецька"),
    VINNYTSIA_OBLAST("Вінницька"),
    MYKOLAIV_OBLAST("Миколаївська"),
    KIROVOHRAD_OBLAST("Кіровоградська"),
    SUMY_OBLAST("Сумська"),
    LVIV_OBLAST("Львівська"),
    CHERKASY_OBLAST("Черкаська"),
    KHMELNYTSKIY_OBLAST("Хмельницька"),
    VOLYN_OBLAST("Волинська"),
    RIVNE_OBLAST("Рівненська"),
    IVANO_FRANKIVSK_OBLAST("Івано-Франківська"),
    TERNOPIL_OBLAST("Тернопільська"),
    ZAKARPATTIA_OBLAST("Закарпатська"),
    CHERNIVTSY_OBLAST("Чернівецька"),
    KIEV("Київ"),
    AR_KRYM("АР Крим"),
    SEVASTOPOL("Севастополь");

    public String getName() {
        return name;
    }

    private String name;

    District(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static District getDistrict(String strDistrict) {
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
                System.out.println("Not correct district");
                returnDistrict = null;

        }
        return returnDistrict;
    }


}
