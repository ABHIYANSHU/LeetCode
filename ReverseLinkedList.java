package LeetCode;

public class ReverseLinkedList {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 42.8 MB, less than 64.94% of Java online submissions for Reverse Linked List.
     */
    public ListNode reverseListUsingLoop(ListNode head) {
        if (head != null) {
            ListNode reversedList = new ListNode(head.val);
        
            while (head.next != null) { // O(n)
                head = head.next;
                reversedList = new ListNode(head.val, reversedList);
            }
            
            return reversedList;
        }
        
        return null;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 42.7 MB, less than 70.59% of Java online submissions for Reverse Linked List.
     */
    public ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode newHead = reverseListUsingRecursion(head.next);
        
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}