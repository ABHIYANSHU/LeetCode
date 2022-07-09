package LeetCode;

import java.util.Stack;

public class ValidParentheses {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 2 ms, faster than 89.73% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.7 MB, less than 6.14% of Java online submissions for Valid Parentheses.
     */
    public boolean isValidUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) { // O(n)
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // O(1)
            } else if (stack.empty()) {
                if (c == ')' || c == '}' || c == ']')
                    return false;
            } else if (!stack.empty()) {
                char poped = stack.pop(); // O(1)
                if (c == ')' && poped != '(')
                    return false;
                else if (c == '}' && poped != '{')
                    return false;
                else if (c == ']' && poped != '[')
                    return false;
            }
        }
        
        return stack.empty(); // O(1)
    }
}
