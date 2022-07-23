package LeetCode;

public class MinimumCostOfClimbingStairs {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n + 1) = O(n)
     * Runtime: 1 ms, faster than 89.43% of Java online submissions for Min Cost Climbing Stairs.
     * Memory Usage: 43.5 MB, less than 54.96% of Java online submissions for Min Cost Climbing Stairs.
     */
    public int minCostClimbingStairsUsingMemorization(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n + 1; i++){
            if (i == n) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            } else {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
        }
        
        return dp[n];
    }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * Stack Overflow
     */
    public int minCostUsingRecursion(int[] cost, int n) {
        if (n < 0) 
            return 0;
        if (n==0 || n==1) 
            return cost[n];
        
        return cost[n] + Math.min(minCostUsingRecursion(cost, n-1), minCostUsingRecursion(cost, n-2));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms, faster than 89.43% of Java online submissions for Min Cost Climbing Stairs.
     * Memory Usage: 43.2 MB, less than 77.53% of Java online submissions for Min Cost Climbing Stairs.
     */
    public int minCostClimbingStairsUsingMemorizationOptimized(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2) 
            return Math.min(first, second);
        
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }
}