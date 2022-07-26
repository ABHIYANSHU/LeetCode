package LeetCode;

public class TwoSumII {
    
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] num, int target) {
        int n = num.length;
        
        int ptr1 = 0;
        int ptr2 = n - 1;
        
        while (ptr1 < ptr2) {
            if (num[ptr1] + num[ptr2] > target) {
                ptr2--;
            } else if (num[ptr1] + num[ptr2] < target) {
                ptr1++;
            } else {
                break;
            }
        }
        
        return new int[] {ptr1 + 1, ptr2 + 1};
    }
}
