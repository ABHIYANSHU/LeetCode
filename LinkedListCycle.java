package LeetCode;

import java.util.HashMap;

public class LinkedListCycle {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1), as we are just referencing the nodes not creating a new one
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 46 MB, less than 39.98% of Java online submissions for Linked List Cycle.
     */
    public boolean hasCycleUsingTwoPointers(ListNode head) {
        if (head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow.equals(fast))
                return true;
        }
         
        return false;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n), as we are creating a hashmap of size n
     * Runtime: 4 ms, faster than 19.65% of Java online submissions for Linked List Cycle.
     * Memory Usage: 43.2 MB, less than 95.90% of Java online submissions for Linked List Cycle.
     */
    public boolean hasCycleUsingHashMap(ListNode head) {
        if (head == null)
            return false;
        
        HashMap<ListNode, Boolean> map = new HashMap<>();
        
        while (head != null) { // O(n)
            if (map.containsKey(head)) // O(1)
                return true;
            
            map.put(head, true);
            head = head.next;
        }
         
        return false;
    }
}
