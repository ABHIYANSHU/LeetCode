package LeetCode;

import java.util.Arrays;

public class ClimbingStairs {

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * Time Limit Exceeded
     */
    public int climbingStairsUsingRecursion(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        
        return climbingStairsUsingRecursion(n - 1) + climbingStairsUsingRecursion(n - 2);
    }

    /**
     * Time Complexity: O(n + 2) + O(n) = O(n)
     * Space Complexity: O(n + 2) = O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 40.8 MB, less than 49.40% of Java online submissions for Climbing Stairs.
     */
    public int climbStairsUsingMemorization(int n) {
        int[] dp = new int[n + 2];
        Arrays.fill(dp, 0); // O(n + 2)
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 2; i++) { // O(n)
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
