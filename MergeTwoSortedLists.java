package LeetCode;

public class MergeTwoSortedLists {

    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 41.9 MB, less than 89.44% of Java online submissions for Merge Two Sorted Lists.
     */
    public ListNode mergeTwoListsUsingLoop(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(0);
        ListNode copyOfMergedList = mergedList;
        
        while (list1 != null && list2 != null) { // O(n + m)
            if (list1.val <= list2.val) {
                copyOfMergedList.next = list1;
                list1 = list1.next;
            }
            else {
                copyOfMergedList.next = list2;
                list2 = list2.next;
            }
            
            copyOfMergedList = copyOfMergedList.next;
        }
        
        if (list1 != null) { // O(1)
            copyOfMergedList.next = list1;
        }
        
        if (list2 != null) { // O(1)
            copyOfMergedList.next = list2;
        }
        
        return mergedList.next;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 42.8 MB, less than 70.33% of Java online submissions for Merge Two Sorted Lists.
     */
    public ListNode mergeTwoListsUsingRecursion(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        
        if (list2 == null)
            return list1;
        
        ListNode mergedList;
        if (list1.val <= list2.val) {
            mergedList = list1;
            mergedList.next = mergeTwoListsUsingRecursion(list1.next, list2);
        }
        else {
            mergedList = list2;
            mergedList.next = mergeTwoListsUsingRecursion(list1, list2.next);
        }
        
        return mergedList;
    }
}
