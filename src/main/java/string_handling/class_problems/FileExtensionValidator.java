package string_handling.class_problems;

public class FileExtensionValidator {

    // Key idea: the extension is whatever follows the LAST dot (so "a.b.pdf" works);
    // compare it case-insensitively with the accepted list.
    static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0) return "Rejected -- invalid file type";
        String ext = filename.substring(dot + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected -- invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
