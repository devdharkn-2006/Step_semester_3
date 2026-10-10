package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Key idea: name and salary are shared in the base class; each subclass overrides only
// the bonus rule, and payroll just calls bonus() on every StaffMember.
abstract class StaffMember {
    protected final String name;
    protected final double salary;

    StaffMember(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() { return name; }
    abstract double bonus();
}

class FullTimeEmployee extends StaffMember {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.10; }
}

class PartTimeEmployee extends StaffMember {
    PartTimeEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return salary * 0.05; }
}

class InternEmployee extends StaffMember {
    InternEmployee(String name, double salary) { super(name, salary); }
    double bonus() { return 2000; } // fixed, salary ignored
}

public class FestivalBonusCalculator {
    static StaffMember create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            default: return new InternEmployee(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            staff.add(create(sc.next(), sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (StaffMember s : staff) {
            double b = s.bonus();
            System.out.printf("%s: %.2f%n", s.getName(), b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
