package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Key idea: the extra "occupants" value lives inside SharedRoom (set by its constructor),
// so the main loop still treats every room as just a Room with bill().
abstract class Room {
    protected final int units;

    Room(int units) { this.units = units; }

    abstract String label();
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    String label() { return "SINGLE"; }
    double bill() { return 8.0 * units; }
}

class SharedRoom extends Room {
    private final int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    String label() { return "SHARED"; }
    double bill() { return 6.0 * units / occupants; } // per-occupant share
}

class AcRoom extends Room {
    AcRoom(int units) { super(units); }
    String label() { return "AC"; }
    double bill() { return 10.0 * units + 200; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("SINGLE")) rooms.add(new SingleRoom(units));
            else if (type.equals("SHARED")) rooms.add(new SharedRoom(units, sc.nextInt()));
            else rooms.add(new AcRoom(units));
        }
        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            System.out.printf("%s: %.2f%n", r.label(), b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
