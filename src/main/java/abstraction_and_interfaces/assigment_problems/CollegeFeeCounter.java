package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

// The bus is an ability only some students have; the 12000 fee lives here, once.
interface BusUser {
    double TRANSPORT_FEE = 12000;
}

// Key idea: every student has a name and a tuition rule (abstract); the counter asks
// "is this a BusUser?" via the interface instead of comparing type names.
abstract class CollegeStudent {
    protected final String name;

    CollegeStudent(String name) { this.name = name; }

    String getName() { return name; }
    abstract double tuitionAndExtras();

    double totalFee() {
        double fee = tuitionAndExtras();
        if (this instanceof BusUser) fee += BusUser.TRANSPORT_FEE;
        return fee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    DayScholar(String name) { super(name); }
    double tuitionAndExtras() { return 40000; }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) { super(name); }
    double tuitionAndExtras() { return 40000 + 60000; } // tuition + hostel fee, no bus
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    ScholarshipStudent(String name) { super(name); }
    double tuitionAndExtras() { return 40000 / 2.0; } // half of normal tuition
}

public class CollegeFeeCounter {
    static CollegeStudent create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            default: return new ScholarshipStudent(name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            CollegeStudent s = create(sc.next(), sc.next());
            System.out.printf("%s: %.2f%n", s.getName(), s.totalFee());
            total += s.totalFee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
