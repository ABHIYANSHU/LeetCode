package LeetCode;

public class KnapSack01 {
    
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(1)
     * Time Limit Exceeded
     */
    public int knapSackUsingRecursion(int W, int wt[], int val[], int n) 
    { 
        // your code here
        if (n == 0)
            return 0;
        
        if (wt[n - 1] > W)
            return knapSackUsingRecursion(W, wt, val, n - 1);
        
        return Math.max(val[n - 1] + knapSackUsingRecursion(W - wt[n - 1], wt, val, n - 1),
        knapSackUsingRecursion(W, wt, val, n - 1));
    }

    /**
     * Time Complexity: O(n*W)
     * Space Complexity: O(n*W)
     */
    public int knapSackUsingMemorization(int W, int wt[], int val[], int n) 
    { 
        if (n == 0)
            return 0;
        
        int i, j;
        int dp[][] = new int[n + 1][W + 1];

        for (i = 0; i < n + 1; i++)
        {
            for (j = 0; j < W + 1; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                        dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
 
        return dp[n][W];
    }
}
