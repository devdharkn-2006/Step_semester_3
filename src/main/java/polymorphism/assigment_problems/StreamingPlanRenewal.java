package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Key idea: each plan only supplies its validity in days; the shared renewalDate()
// adds it to the start date with LocalDate.plusDays(), which handles leap years and year changes.
abstract class Plan {
    protected final String name;
    protected final LocalDate start;

    Plan(String name, LocalDate start) {
        this.name = name;
        this.start = start;
    }

    abstract int validityDays();

    LocalDate renewalDate() { return start.plusDays(validityDays()); }
    String getName() { return name; }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate start) { super(name, start); }
    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate start) { super(name, start); }
    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate start) { super(name, start); }
    int validityDays() { return 365; }
}

public class StreamingPlanRenewal {
    static Plan create(String type, String name, LocalDate start) {
        switch (type) {
            case "BASIC": return new BasicPlan(name, start);
            case "STANDARD": return new StandardPlan(name, start);
            default: return new PremiumPlan(name, start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plans.add(create(sc.next(), sc.next(), LocalDate.parse(sc.next())));
        }
        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}
