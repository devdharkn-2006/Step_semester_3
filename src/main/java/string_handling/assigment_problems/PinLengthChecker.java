package string_handling.assigment_problems;

public class PinLengthChecker {

    // Key idea: no loop needed, just compare length() with 4.
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN -- must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }
}
