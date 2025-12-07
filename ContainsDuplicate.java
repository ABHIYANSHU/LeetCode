package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n + n log n) = O(n log n)
     * Space Complexity: O(1)
     * Runtime: 24 ms, faster than 16.44% of Java online submissions for Contains Duplicate.
     * Memory Usage: 76.84 MB, less than 16.44% of Java online submissions for Contains Duplicate.
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
     * @author: @ABHIYANSHU
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 16 ms, faster than 41.95% of Java online submissions for Contains Duplicate.
     * Memory Usage: 96.85 MB, less than 9.39% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) { // O(n)
            if (!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            } else {
                return true;
            }
        }
        
        return false;
    }

    /**
     * @author: @ABHIYANSHU
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 15 ms, faster than 55.81% of Java online submissions for Contains Duplicate.
     * Memory Usage: 96.73 MB, less than 10.25% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingHashMap2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>(); // As we dont need to count number of occurence only check if they already exist or not
        
        for(int num : nums) { // O(n)
            if (map.containsKey(num))
                return true;
            else
                map.put(num, true);
            }
        
        return false;
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 29 ms, faster than 5.17% of Java online submissions for Contains Duplicate.
     * Memory Usage: 83.04 MB, less than 44.13% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingStream(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length; // O(n)
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 11 ms, faster than 91.79% of Java online submissions for Contains Duplicate.
     * Memory Usage: 97.64 MB, less than 7.30% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingHashSet(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        
        for(int num:nums) { // O(n)
            if(!set.add(num))
                return true;
        }
        
        return false;
    }

    /**
     * @author: @LeetCode
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 15 ms, faster than 55.81% of Java online submissions for Contains Duplicate.
     * Memory Usage: 55.60 MB, less than 99.94% of Java online submissions for Contains Duplicate.
     */
    public static boolean containsDuplicateByUsingHashSetWithLessMemory(int[] nums) {
        System.gc();
        
        HashSet<Integer> set= new HashSet<>();
        
        for(int num:nums) { // O(n)
            if(!set.add(num))
                return true;
        }
        
        return false;
    }

}