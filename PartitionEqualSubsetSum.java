package LeetCode;

public class PartitionEqualSubsetSum {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n*sum)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % 2 != 0)
            return false;
        
        sum = sum / 2;
        
        return subsetSum(nums, nums.length, sum);
    }

    private boolean subsetSum(int[] nums, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        dp[0][0] = true;
        
        for (int i = 1; i < n + 1; i++)
            dp[i][0] = true;
        
        for (int i = 1; i < sum + 1; i++)
            dp[0][i] = false;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        
        return dp[n][sum];
    }
}
