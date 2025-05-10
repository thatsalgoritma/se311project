package Project;

import java.util.HashMap;
import java.util.Map;

// Singleton class to store cattle location data globally
class FarmDatabase {

    private static FarmDatabase instance;

    private Map<String, Integer> cattleLocationData;  // holds the cattle IDs and their locations

    // private constructor
    private FarmDatabase() {
        cattleLocationData = new HashMap<>();
    }

    // provides global access point to the single instance
    public static synchronized FarmDatabase getInstance() {
        if (instance == null) {
            instance = new FarmDatabase();
        }
        return instance;
    }

    // updates cattle location 
    public void updateLocation(String cattleId, Integer location) {
        cattleLocationData.put(cattleId, location);
        System.out.println(cattleId + " is " + location + " meters away from farm!");
    }

    // gets location of a specific cattle
    public Integer getLocation(String cattleId) {
        return cattleLocationData.get(cattleId);
    }
}
