package Project;

import java.util.ArrayList;
import java.util.List;

 interface Observer {
    void update(String cattleId, Integer location);
}

 interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String cattleId, Integer location);
}

 class LocationTracker implements Subject {
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String cattleId, Integer location) {
        for (Observer obs : observers) {
            obs.update(cattleId, location);
        }
    }

    public void checkLocation(String cattleId, Integer location) {
        if (location >= 100) {
            notifyObservers(cattleId, location);
        }
    }
}


 class Farmer implements Observer {
    private String name;

    public Farmer(String name) {
        this.name = name;
    }

    @Override
    public void update(String cattleId, Integer location) {
        System.out.println("\uD83D\uDEA8 Alert for " + name + ": Cattle " + cattleId + " has exited the farm!");
    }
}