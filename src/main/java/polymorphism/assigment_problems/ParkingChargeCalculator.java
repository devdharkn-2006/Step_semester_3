package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Key idea: every vehicle type overrides charge(); the caller just sums charge() over a list.
abstract class Vehicle {
    protected final int hours;

    Vehicle(int hours) { this.hours = hours; }

    abstract String label();
    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }
    String label() { return "BIKE"; }
    double charge() { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }
    String label() { return "CAR"; }
    double charge() { return 30.0 + 20.0 * (hours - 1); } // first hour 30, then 20 each extra
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }
    String label() { return "TRUCK"; }
    double charge() { return Math.max(100.0, 50.0 * hours); } // minimum charge of 100
}

public class ParkingChargeCalculator {
    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            default: return new Truck(hours);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vehicles.add(create(sc.next(), sc.nextInt()));
        }
        double total = 0;
        for (Vehicle v : vehicles) {
            double c = v.charge();
            System.out.printf("%s: %.2f%n", v.label(), c);
            total += c;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
