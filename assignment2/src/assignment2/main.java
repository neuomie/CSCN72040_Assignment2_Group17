package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Subject interface
interface GPS {
    void registerObserver(Observer observer); //to register an observer
    void removeObserver(Observer observer); // to remove an observer or unregister an observer.
    void notifyObservers(); // to notify observers of the changes.
    void changeLocation(int x, int y); //to change the location.
    double getDistance(int x, int y);//to calculate distance from given point.
}

// Concrete subject class
class VehicleGPS implements GPS {
    private List<Observer> observers = new ArrayList<>();
    private int x;
    private int y;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void changeLocation(int x, int y) {
        this.x = x;
        this.y = y;
        notifyObservers();
    }

    @Override
    //get distance by formula.
    public double getDistance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }
}

// Observer interface
interface Observer 
{
    void update(GPS subject);// to change observer with changes in subject.
}

// DangerZoneObserver class
class DangerZoneObserver implements Observer {
    private static final int DANGER_ZONE_X = 6;
    private static final int DANGER_ZONE_Y = 6;
    private static final int DANGER_ZONE_RADIUS = 3;

    @Override
    //update method.
    public void update(GPS subject) {
        double distanceFromDangerZone = subject.getDistance(DANGER_ZONE_X, DANGER_ZONE_Y);
        if (distanceFromDangerZone <= DANGER_ZONE_RADIUS) {
            System.out.println("WARNING: Vehicle in Danger Zone!");
        } else {
            System.out.println("Vehicle is not in the Danger Zone.");
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleGPS gps = new VehicleGPS();
        DangerZoneObserver dangerZoneObserver = new DangerZoneObserver();

        gps.registerObserver(dangerZoneObserver); // Register DangerZoneObserver

        System.out.println("Enter the x-coordinate:");
        int x = scanner.nextInt();

        System.out.println("Enter the y-coordinate:");
        int y = scanner.nextInt();

        gps.changeLocation(x, y); // Change vehicle location

        scanner.close();
    }
}
