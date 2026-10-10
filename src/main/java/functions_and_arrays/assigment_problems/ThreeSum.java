package functions_and_arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // Key idea: sort, fix one value, then sweep two pointers inward to find the pair that
    // cancels it. Skipping equal neighbours at all three levels removes duplicate triplets.
    static int[][] threeSum(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) break;                       // smallest value positive: no zero-sum possible
            if (i > 0 && a[i] == a[i - 1]) continue;   // skip duplicate first value
            int lo = i + 1, hi = a.length - 1;
            while (lo < hi) {
                int sum = a[i] + a[lo] + a[hi];
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    result.add(new int[]{a[i], a[lo], a[hi]});
                    lo++;
                    hi--;
                    while (lo < hi && a[lo] == a[lo - 1]) lo++;  // skip duplicate second value
                    while (lo < hi && a[hi] == a[hi + 1]) hi--;  // skip duplicate third value
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));
    }
}
