package LeetCode;

public class SingleNumber {
    
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Single Number.
     * Memory Usage: 42 MB, less than 99.29% of Java online submissions for Single Number.
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for (int num : nums) {
            ans ^= num;
        }
        
        return ans;
    }
}
