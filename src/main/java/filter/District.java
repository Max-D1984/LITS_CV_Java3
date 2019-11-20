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

    private String name;

    District(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }




}
