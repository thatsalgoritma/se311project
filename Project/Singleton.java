package Project;

import java.util.HashMap;
import java.util.Map;

class FarmDatabase {

    private static FarmDatabase instance;

    private Map<String, Integer> cattleLocationData;

    private FarmDatabase() {
        cattleLocationData = new HashMap<>();
    }

    public static synchronized FarmDatabase getInstance() {
        if (instance == null) {
            instance = new FarmDatabase();
        }
        return instance;
    }

    public void updateLocation(String cattleId, Integer location) {
        cattleLocationData.put(cattleId, location);
        System.out.println( cattleId + " is " + location + " meters away from farm!");
    }

    public Integer getLocation(String cattleId) {
        return cattleLocationData.get(cattleId);
    }
}