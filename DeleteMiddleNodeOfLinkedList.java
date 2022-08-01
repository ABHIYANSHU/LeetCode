package LeetCode;

public class DeleteMiddleNodeOfLinkedList {

    /**
     * Time Complexity: O(n / 2) = O(n)
     * Space Complexity: O(1)
     * Runtime: 4 ms, faster than 96.42% of Java online submissions for Delete the Middle Node of a Linked List.
     * Memory Usage: 63.2 MB, less than 95.48% of Java online submissions for Delete the Middle Node of a Linked List.
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;
        return head;
    }
}
