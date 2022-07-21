package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargestElementInAStream {

    /**
     * Time Complexity: O(n) + O(nlog n) = O(nlog n)
     * Space Complexity: O(n)
     * Time Limit Exceeded, but all test cases were passed
     * 
     * Runtime: 24 ms, faster than 50.68% of Java online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 53.3 MB, less than 15.06% of Java online submissions for Kth Largest Element in a Stream.
     * 
     * Runtime: 22 ms, faster than 60.44% of Java online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 52.6 MB, less than 41.92% of Java online submissions for Kth Largest Element in a Stream.
     * 
     * 
     * 
     */
    class KthLargestBruteForce {

        private ArrayList<Integer> list;
        private int k;
        
        public KthLargestBruteForce(int k, int[] nums) {
            list = new ArrayList<>();
            this.k = k;
            for (int num : nums) // O(n)
                list.add(num);
        }
        
        public int add(int val) {
            list.add(val);
            Collections.sort(list); // O(nlog n)
            return list.get(list.size() - k);
        }
    }
}
