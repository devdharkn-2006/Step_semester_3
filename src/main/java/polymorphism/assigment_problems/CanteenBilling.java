package polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Key idea: each customer type overrides finalAmount(), so the billing loop calls the
// same method on every bill and never checks the type with if-else.
abstract class Customer {
    protected final double amount;

    Customer(double amount) { this.amount = amount; }

    abstract String label();
    abstract double finalAmount();
}

class Student extends Customer {
    Student(double amount) { super(amount); }
    String label() { return "STUDENT"; }
    double finalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }
    String label() { return "STAFF"; }
    double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }
    String label() { return "GUEST"; }
    double finalAmount() { return amount + 10; }
}

public class CanteenBilling {
    // The only place the type string is looked at: building the object.
    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF": return new Staff(amount);
            default: return new Guest(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bills.add(create(sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (Customer c : bills) {
            double fa = c.finalAmount();
            System.out.printf("%s: %.2f%n", c.label(), fa);
            total += fa;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
