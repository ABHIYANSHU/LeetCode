package LeetCode;

public class BalancedBinaryTree {

    private boolean result = false;
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        
        height(root);
        
        return !result;
    }
    
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms, faster than 99.01% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 43.6 MB, less than 80.72% of Java online submissions for Balanced Binary Tree.
     */
    public int height(TreeNode root) {
        if (root == null || result)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if (Math.abs(left - right) > 1)
            result = true;
        
        return Math.max(left, right) + 1;
    }
}