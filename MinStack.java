package LeetCode;

import java.util.Stack;

/**
* Your MinStack object will be instantiated and called as such:
* MinStackUsingTwoStack obj = new MinStackUsingTwoStack();
* obj.push(val);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/
public class MinStack {

    /**
     * Time Complexity: O(1)
     * Space Complexity: O(n) + O(n) = O(n)
     * Runtime: 4 ms, faster than 97.51% of Java online submissions for Min Stack.
     * Memory Usage: 44.3 MB, less than 86.69% of Java online submissions for Min Stack.
     */
    static class MinStackUsingTwoStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStackUsingTwoStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
    
        public void push(int val) {
            stack.push(val); // O(1)
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val); // O(1)
            }
        }
    
        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop(); // O(1)
            }
            stack.pop(); // O(1)
        }
    
        public int top() {
            return stack.peek(); // O(1)
        }
    
        public int getMin() {
            return minStack.peek(); // O(1)
        }
    }

    /**
    * Time Complexity: O(1)
    * Space Complexity: O(n)
    * Runtime: 6 ms, faster than 78.28% of Java online submissions for Min Stack.
    * Memory Usage: 48.3 MB, less than 60.21% of Java online submissions for Min Stack.
    */
    static class MinStackUsingNode {
        private Node head;
        
        public MinStackUsingNode() {
            
        }
        
        public void push(int val) {
            if (head == null) {
                head = new Node(val, val, null); // O(1)
            } else {
                head = new Node(val, Math.min(val, head.min), head); // O(1)
            }
        }
    
        public void pop() {
            head = head.next; // O(1)
        }
    
        public int top() {
            return head.val; // O(1)
        }
    
        public int getMin() {
            return head.min; // O(1)
        }
    }
    
    static class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}