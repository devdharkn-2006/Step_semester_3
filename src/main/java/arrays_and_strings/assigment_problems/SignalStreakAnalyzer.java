package arrays_and_strings.assigment_problems;

public class SignalStreakAnalyzer {

    // Key idea: keep the current run length; reset it to 1 when the color changes.
    // Update the best run only when it is strictly longer (earliest streak wins ties).
    static void findLongestStreak(String signalLog) {
        char bestColor = signalLog.charAt(0);
        int bestLen = 1;
        int curLen = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > bestLen) {
                bestLen = curLen;
                bestColor = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLen + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
