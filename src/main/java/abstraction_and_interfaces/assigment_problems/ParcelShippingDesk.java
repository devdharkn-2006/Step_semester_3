package abstraction_and_interfaces.assigment_problems;

import java.util.Scanner;

// Insurance is a separate ability, so it is an interface only some parcels implement.
// Making another parcel insurable later means adding "implements Insurable" to it alone.
interface Insurable {
    double INSURANCE_RATE = 0.02;
    double insurance();
}

// Key idea: every parcel can answer "what is the shipping charge?" (abstract method);
// only some can answer "what is the insurance?" (the interface).
abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract String label();
    abstract double charge();

    // Non-insurable parcels pay no insurance; insurable ones report it through the interface.
    double insuranceAmount() {
        return (this instanceof Insurable) ? ((Insurable) this).insurance() : 0;
    }

    double total() { return charge() + insuranceAmount(); }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    String label() { return "STANDARD"; }
    double charge() { return 40 + 10 * weightKg; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    String label() { return "EXPRESS"; }
    double charge() { return 80 + 15 * weightKg; }
    public double insurance() { return declaredValue * INSURANCE_RATE; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    String label() { return "FRAGILE"; }
    double charge() { return 40 + 10 * weightKg + 50; } // standard charge + handling fee
    public double insurance() { return declaredValue * INSURANCE_RATE; }
}

public class ParcelShippingDesk {
    static Parcel create(String type, double w, double v) {
        switch (type) {
            case "STANDARD": return new StandardParcel(w, v);
            case "EXPRESS": return new ExpressParcel(w, v);
            default: return new FragileParcel(w, v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            Parcel p = create(sc.next(), sc.nextDouble(), sc.nextDouble());
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.label(), p.charge(), p.insuranceAmount(), p.total());
            grand += p.total();
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
