package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {

    /**
     * Time Complexity: O(n + n log n) = O(n log n)
     * Space Complexity: O(1)
     * Runtime: 19 ms, faster than 35.01% of Java online submissions for Contains Duplicate.
     * Memory Usage: 56.7 MB, less than 83.10% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingSort(int[] nums) {
        Arrays.sort(nums); // O(n log n)        
        int lastVisitedItem = nums[0];
        for (int i = 1; i < nums.length; i++) { // O(n)
            if (nums[i] == lastVisitedItem)
                return true;
            
            lastVisitedItem = nums[i];
        }
        
        return false;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 6 ms, faster than 96.68% of Java online submissions for Contains Duplicate.
     * Memory Usage: 55.1 MB, less than 87.27% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++){ // O(n)
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            } else {
                return true;
            }
        }
        
        return false;
    }
}