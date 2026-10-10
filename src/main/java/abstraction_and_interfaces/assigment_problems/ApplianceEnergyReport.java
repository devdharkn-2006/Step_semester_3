package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

// Saver mode is an ability only some appliances have.
interface SaverMode {
    double SAVER_FACTOR = 0.75; // saver mode cuts energy use by 25%
}

// Key idea: every appliance computes units from its own wattage (abstract rating);
// the report asks "is it a SaverMode?" instead of listing appliance names.
abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;

    abstract String label();
    abstract double watts();

    double units(double hours, boolean saver) {
        double kwh = watts() * hours / 1000;
        return saver ? kwh * SaverMode.SAVER_FACTOR : kwh;
    }

    double cost(double units) { return units * RATE_PER_UNIT; }
}

class Fridge extends Appliance {
    String label() { return "FRIDGE"; }
    double watts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    String label() { return "AC"; }
    double watts() { return 1500; }
}

class Television extends Appliance {
    String label() { return "TV"; }
    double watts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    String label() { return "WASHER"; }
    double watts() { return 500; }
}

public class ApplianceEnergyReport {
    static Appliance create(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Television();
            default: return new WashingMachine();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            // A line is "APPLIANCE hours" or "APPLIANCE hours SAVER".
            String[] parts = sc.nextLine().trim().split("\\s+");
            Appliance a = create(parts[0]);
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2;

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(a.label() + ": saver mode not supported");
                continue;
            }
            double units = a.units(hours, saver);
            double cost = a.cost(units);
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.label(), units, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}
