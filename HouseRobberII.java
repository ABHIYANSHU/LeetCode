package LeetCode;

public class HouseRobberII {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) + O(n) = O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
     * Memory Usage: 41.6 MB, less than 47.96% of Java online submissions for House Robber II.
     */
    public int robUsingTopDownApproach(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];
        
        int[] startFromFirstHouse = new int[nums.length + 1];
        int[] startFromSecondHouse = new int[nums.length + 1];
        
        startFromFirstHouse[0]  = 0;
        startFromFirstHouse[1]  = nums[0];
        startFromSecondHouse[0] = 0;
        startFromSecondHouse[1] = 0;
        
        for (int i = 2; i <= nums.length; i++) {
            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i-1]);
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i-1]);
        }
        
        return Math.max(startFromFirstHouse[nums.length - 1],   startFromSecondHouse[nums.length]);
    }


    /**
     * Time Complexity: O(n - 1) + O (n - 1) = O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms, faster than 38.39% of Java online submissions for House Robber II.
     * Memory Usage: 41.6 MB, less than 47.96% of Java online submissions for House Robber II.
     */
    public int robUsingMemorizationOprimized(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        
        return Math.max(robHelper(nums, 0, n - 1), robHelper(nums, 1, n));
    }
    
    private int robHelper(int[] nums, int start,int end) {
        
        int rob1 = 0;
        int rob2 = 0;
        
        for (int i = start; i < end; i++) {
            int temp = rob1;
            rob1 = Math.max(rob2 + nums[i], rob1);
            rob2 = temp;
        }
        
        return rob1;
    }
}
