package arrays_and_strings.assigment_problems;

public class ReviewWordLengthProfiler {

    // Key idea: split on whitespace, then bucket each word by its length:
    // 1-4 Short, 5-8 Medium, 9+ Long.
    static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;
        for (String word : review.trim().split("\\s+")) {
            int len = word.length();
            if (len == 0) continue;
            if (len <= 4) shortCount++;
            else if (len <= 8) mediumCount++;
            else longCount++;
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
