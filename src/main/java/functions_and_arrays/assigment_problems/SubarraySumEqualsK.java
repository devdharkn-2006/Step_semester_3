package functions_and_arrays.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // Key idea: sum(i+1..j) = prefix[j] - prefix[i], so at each j count earlier prefixes equal to
    // (prefix[j] - k). The map starts with {0:1} to represent the empty prefix.
    // Sliding window fails here because negatives mean extending a window can lower its sum.
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 1);
        int prefix = 0, count = 0;
        for (int x : nums) {
            prefix += x;
            count += seen.getOrDefault(prefix - k, 0);
            seen.merge(prefix, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
