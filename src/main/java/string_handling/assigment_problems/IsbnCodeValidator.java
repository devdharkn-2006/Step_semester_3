package string_handling.assigment_problems;

public class IsbnCodeValidator {

    // Key idea: trim, then uppercase just the 3-letter publisher code (substring + concat).
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Key idea: validate in stages (length, letters, digits) so each failure
    // gives its own message. Layout: 3 letters + 4-digit year + 6-digit catalog.
    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be 13 characters";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: year and catalog must be digits";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(code, 0, 3).append("] YEAR: ").append(code, 3, 7)
          .append(" | CATALOG: ").append(code.substring(7));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
