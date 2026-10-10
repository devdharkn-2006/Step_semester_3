package string_handling.class_problems;

public class TransactionReferenceValidator {

    // Key idea: trim stray spaces, then uppercase only the 3-letter bank code
    // via substring + concatenation so the digits are left untouched.
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Key idea: run the checks in order (length, bank code, body) so the first
    // failure reports a specific reason. Layout: 3 letters + ddMMyy + 5-digit sequence.
    static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: reference must be 14 characters";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: date and sequence must be digits";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(reference, 0, 3).append("] DATE: ")
          .append(reference, 3, 5).append('/')
          .append(reference, 5, 7).append('/')
          .append(reference, 7, 9)
          .append(" | SEQ: ").append(reference.substring(9));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}
