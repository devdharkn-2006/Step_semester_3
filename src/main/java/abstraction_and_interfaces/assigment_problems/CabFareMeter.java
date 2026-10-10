package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

// Night service is an ability only some cabs choose to have (implement).
interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

// Key idea: the minimum-fare rule is written once in the abstract base class; subclasses
// supply only their per-km rate. A cab without NightService cannot take a night trip.
abstract class Cab {
    private static final double MIN_FARE = 100;

    abstract String label();
    abstract double ratePerKm();

    double dayFare(double km) {
        return Math.max(MIN_FARE, km * ratePerKm());
    }

    // Night fare adds 20% after the minimum has been applied.
    double nightFare(double km) {
        return dayFare(km) * (1 + NightService.NIGHT_SURCHARGE);
    }
}

class MiniCab extends Cab {
    String label() { return "MINI"; }
    double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    String label() { return "SEDAN"; }
    double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    String label() { return "SUV"; }
    double ratePerKm() { return 18; }
}

public class CabFareMeter {
    static Cab create(String type) {
        switch (type) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            default: return new SuvCab();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = create(sc.next());
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");

            if (!night) {
                double fare = cab.dayFare(km);
                System.out.printf("%s: %.2f%n", cab.label(), fare);
                total += fare;
            } else if (cab instanceof NightService) {
                double fare = cab.nightFare(km);
                System.out.printf("%s: %.2f%n", cab.label(), fare);
                total += fare;
            } else {
                System.out.println(cab.label() + ": night service not available");
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
