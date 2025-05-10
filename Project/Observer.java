package Project;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String cattleId, Integer location);
}

// Subject is used by the class that tracks changes such as LocationTracker
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String cattleId, Integer location);
}

// LocationTracker is a Subject that notifies observers when a cattle goes far
class LocationTracker implements Subject {
    private List<Observer> observers = new ArrayList<>();  // List of all observers

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

    // Method to check cattle’s location. If it’s too far it will notify observers
    public void checkLocation(String cattleId, Integer location) {
        if (location >= 100) { // If the cattle is 100 meters or more away, send an alert
            notifyObservers(cattleId, location);
        }
    }
}

// Farmer is an observer who gets alerts when a cattle goes too far
class Farmer implements Observer {
    private String name;

    public Farmer(String name) {
        this.name = name;
    }

    // This method is called when an alert is sent from LocationTracker
    @Override
    public void update(String cattleId, Integer location) {
        System.out.println("\uD83D\uDEA8 Alert for " + name + ": Cattle " + cattleId + " has exited the farm!");
    }
}
