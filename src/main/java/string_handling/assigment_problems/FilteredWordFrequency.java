package string_handling.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FilteredWordFrequency {

    private static final Set<String> STOP_WORDS =
            new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

    // Key idea: normalize, drop stop words, count with a map, then sort entries by
    // count descending. LinkedHashMap keeps first-seen order, and the stable sort
    // keeps that order among ties.
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : cleaned.trim().split("\\s+")) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) continue;
            counts.merge(word, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
