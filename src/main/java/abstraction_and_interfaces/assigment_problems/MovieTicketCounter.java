package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

// Key idea: the abstract class holds what never changes (count and the 20 fee, written once
// in totalAmount()); subclasses supply only the price. Being abstract, a plain "ticket"
// with no seat type can never be instantiated.
abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20;
    private final int count;

    Ticket(int count) { this.count = count; }

    abstract String label();
    abstract double pricePerTicket();

    final double totalAmount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }
    String label() { return "REGULAR"; }
    double pricePerTicket() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }
    String label() { return "PREMIUM"; }
    double pricePerTicket() { return 250; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) { super(count); }
    String label() { return "RECLINER"; }
    double pricePerTicket() { return 400; }
}

public class MovieTicketCounter {
    static Ticket create(String seat, int count) {
        switch (seat) {
            case "REGULAR": return new RegularTicket(count);
            case "PREMIUM": return new PremiumTicket(count);
            default: return new ReclinerTicket(count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Ticket[] bookings = new Ticket[n];
        for (int i = 0; i < n; i++) {
            bookings[i] = create(sc.next(), sc.nextInt());
        }
        double total = 0;
        for (Ticket t : bookings) {
            System.out.printf("%s: %.2f%n", t.label(), t.totalAmount());
            total += t.totalAmount();
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
