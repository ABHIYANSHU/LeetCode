package LeetCode;

public class TargetSum {
    
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n * sum)
     * Runtime: 10 ms, faster than 76.91% of Java online submissions for Target Sum.
     * Memory Usage: 44.2 MB, less than 36.47% of Java online submissions for Target Sum.
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums)
            sum += x;
        
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        sum = (sum - target)/2;
        
        return noOfWaysSubsetSum(nums, nums.length, sum);
    }
    
    private int noOfWaysSubsetSum(int[] nums, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(nums[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        
        return dp[n][sum];
    }
}
