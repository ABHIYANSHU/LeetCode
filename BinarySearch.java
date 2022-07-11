package LeetCode;

public class BinarySearch {

    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
     * Memory Usage: 53.9 MB, less than 73.41% of Java online submissions for Binary Search.
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        
        while (low <= high)
        {
            mid = (low + high) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return -1;
    }
}
