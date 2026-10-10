package string_handling.class_problems;

public class PhoneNumberMasker {

    // Key idea: validate length and digits first, then build "XXXXXX" + "-" + last 4 digits.
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) return "Invalid phone number";
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) return "Invalid phone number";
        }
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append(phone.substring(6));
        masked.insert(6, "-"); // dash goes between the mask and the last 4 digits
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
