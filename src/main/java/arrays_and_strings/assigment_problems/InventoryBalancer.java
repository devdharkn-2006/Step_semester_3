package arrays_and_strings.assigment_problems;

public class InventoryBalancer {

    // Key idea: one pass accumulates both totals and tracks the maximum with its
    // section and index. Strict ">" keeps the first occurrence (Section A wins ties).
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        int max = Integer.MIN_VALUE;
        char maxSection = 'A';
        int maxIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
            if (sectionA[i] > max) {
                max = sectionA[i];
                maxSection = 'A';
                maxIndex = i;
            }
            if (sectionB[i] > max) {
                max = sectionB[i];
                maxSection = 'B';
                maxIndex = i;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status + " | Highest Quantity: " + max
                + " (Section " + maxSection + ", Item " + (maxIndex + 1) + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
