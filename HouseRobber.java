package LeetCode;

public class HouseRobber {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 41.8 MB, less than 30.36% of Java online submissions for House Robber.
     */
    public int robTopDownApproach(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        
        return dp[n];
    }

    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * Stack Overflow
     */
    public int robRecursiveApproach(int[] nums, int n) {
        if (n < 0)
            return 0;

        return Math.max(robRecursiveApproach(nums, n - 2) + nums[n], robRecursiveApproach(nums, n - 1));
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 39.6 MB, less than 92.41% of Java online submissions for House Robber.
     */
    public int robTopDownOptimizedApproach(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
