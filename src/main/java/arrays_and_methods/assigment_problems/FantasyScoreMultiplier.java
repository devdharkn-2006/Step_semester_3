package arrays_and_methods.assigment_problems;

import java.util.Arrays;

public class FantasyScoreMultiplier {

    // Key idea: arrays are passed by reference, so editing playerScores here changes the
    // caller's array. Only the two chosen indices are touched; no loop needed.
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
