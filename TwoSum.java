package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Runtime: 59 ms, faster than 5.02% of Java online submissions for Two Sum.
     * Memory Usage: 46.39 MB, less than 44.37% of Java online submissions for Two Sum.
     */
    public static int[] twoSumWithNestedLoop(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) { // O(n)
            for (int j = i + 1; j < nums.length; j++) { // O(n)
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        
        return ans;
    }

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n) + O(n log n) + O(n) + O(n) = O(n log n)
     * Space Complexity: O(n)
     * Runtime: 6 ms, faster than 46.52% of Java online submissions for Two Sum.
     * Memory Usage: 47.50 MB, less than 8.91% of Java online submissions for Two Sum.
     */
    public int[] twoSumWithTwoPointers(int[] nums, int target) {
        int n  = nums.length;
        int[] ans = new int[2];
        
        int[] numsNew = Arrays.copyOf(nums, n); // O(n)
        
        int i = 0;
        int j = n - 1;
        Arrays.sort(numsNew); // O(n log n)
        
        while (i < j) { // O(n)
            if (numsNew[i] + numsNew[j] == target) { // If true, this loop only runs once
                ans[0] = search(nums, numsNew[i], -1); // O(n)
                ans[1] = search(nums, numsNew[j], ans[0]); // O(n)
                return ans;
            }
            if (numsNew[i] + numsNew[j] < target)
                i++;
            if (numsNew[i] + numsNew[j] > target)
                j--;
        }
        
        return ans;
    }

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 2 ms, faster than 99.10% of Java online submissions for Two Sum.
     * Memory Usage: 46.96 MB, less than 26.09% of Java online submissions for Two Sum.
     */
    public int[] twoSumWithHashMap(int[] nums, int target) {
        int n  = nums.length;
        int[] ans = new int[2];
        
        HashMap<Integer, Integer> maps = new HashMap<>();
        
        for (int i = 0; i < n; i++) { // O(n)
            if (maps.containsKey(nums[i]))
            {
                ans[0] = maps.get(nums[i]); // O(1)
                ans[1] = i;
                break;
            }
            else
                maps.put(target - nums[i], i);
        }
        
        return ans;
    }
    
    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * It searches the item in the array which has not been already searched
     */
    private int search(int[] arr, int num, int found_already) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num && i != found_already) 
                return i; 
        } 
        return 0;
    }
}