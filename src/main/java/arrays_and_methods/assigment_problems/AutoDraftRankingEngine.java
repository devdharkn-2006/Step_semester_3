package arrays_and_methods.assigment_problems;

import java.util.Arrays;

// Key idea: Player is Comparable (highest batting average first, since that is the
// fantasy-points figure in the sample), so Arrays.sort alone does the ranking.
class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    String getName() { return name; }
    int getMatchesPlayed() { return matchesPlayed; }
    boolean isInjured() { return injured; }

    // Overload 1: established players qualify on experience alone (10+ matches).
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overload 2: newer players need 5+ matches AND must be fit.
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage); // descending
    }
}

public class AutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {
        // A player is in if EITHER rule accepts them; count first to size the array.
        int count = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) count++;
        }
        Player[] draftable = new Player[count];
        int idx = 0;
        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed()) || Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[idx++] = p;
            }
        }
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftable[i].getName());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
