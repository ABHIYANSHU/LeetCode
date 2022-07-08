package LeetCode;

public class BestTimeToBuyAndSellStock {
    
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 2 ms, faster than 93.06% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 58.9 MB, less than 94.23% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int maxProfitUsingTwoPointers(int[] prices) {
        int n = prices.length;
        int l, r, maxProfit;
        l = maxProfit = 0;
        r = 1;
        
        for (int i = 0; i < n - 1; i++) { // O(n)
            int profit = prices[r] - prices[l];
            if (profit < 0) {
                l = r;
            }
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            r++;
        }
        
        return maxProfit;
    }


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 5 ms, faster than 12.27% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 84.2 MB, less than 23.97% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int maxProfitByBruteForce(int[] prices) {
        int n = prices.length;
        int max = prices[n-1];
        int min = prices[n-1];
        int profit = max - min;
        int profithere = max - min;
        
        for (int i = n - 2; i > -1; i--) { // O(n)
            if (max - prices[i] < 0)
            {
                max = prices[i];
                min = prices[i];
            }
            else
            {
                if (prices[i] < min)
                {
                    min = prices[i];
                }
            }
            profithere = max - min;
            if (profithere > profit)
                profit = profithere;
        }
        
        return profit;
    }
}
