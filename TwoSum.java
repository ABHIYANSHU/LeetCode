package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Runtime: 55 ms, faster than 39.27% of Java online submissions for Two Sum.
     * Memory Usage: 44.7 MB, less than 74.96% of Java online submissions for Two Sum.
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
     * Time Complexity: O(n) + O(n log n) + O(n) + O(n) = O(n log n)
     * Space Complexity: O(n)
     * Runtime: 4 ms, faster than 74.23% of Java online submissions for Two Sum.
     * Memory Usage: 45.4 MB, less than 47.79% of Java online submissions for Two Sum.
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
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 3 ms, faster than 90.34% of Java online submissions for Two Sum.
     * Memory Usage: 45.4 MB, less than 44.65% of Java online submissions for Two Sum.
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