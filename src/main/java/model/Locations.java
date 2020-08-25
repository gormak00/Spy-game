package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Locations {
    public List<String> getLocations() {
        return locations;
    }

    private List<String> locations;
    public Locations(){
        locations = new ArrayList<>();
        locations.add("дом");
        locations.add("тюрьма");
        locations.add("спортзал");
        locations.add("банк");
        locations.add("заброшка");
        locations.add("туалет");
        locations.add("кофейня");
        locations.add("цирк");
        locations.add("больница");
        locations.add("киностудия");
        locations.add("корпоративная вечеринка");
        locations.add("пассажирский поезд");
        locations.add("пиратский корабль");
        locations.add("посольство");
        locations.add("ресторан");
        locations.add("университет");
        locations.add("супермаркет");
        locations.add("театр");
        locations.add("казино");
        locations.add("воинская часть");
        locations.add("пляж");
        locations.add("подводная лодка");
        locations.add("самолет");
        locations.add("церковь");
    }
}
