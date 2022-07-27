package LeetCode;

public class SubsetSum {
    
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     */
    public boolean isSubsetSumUsingRecursion(int n, int arr[], int sum) {
        // code here
        if (sum == 0)
            return true;
        
        if (n == 0)
            return false;
            
        return isSubsetSumUsingRecursion(n - 1, arr, sum - arr[n - 1]) || isSubsetSumUsingRecursion(n - 1, arr, sum);
    }

    /**
     * Time Complexity: O(n*W)
     * Space Complexity: O(n*W)    
     */
    public boolean isSubsetSumUsingMemorization(int n, int arr[], int sum) {
        // code here
        if (sum == 0)
            return true;
        
        if (n == 0)
            return false;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        
        for (int i = 1; i < n + 1; i++)
            dp[i][0] = true;
            
        for (int i = 1; i < sum + 1; i++)
            dp[0][i] = false;
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
            
        return dp[n][sum];
    }

}
