package LeetCode;

public class DiameterOfBinaryTree {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeUsingRecursion(root);
        return max;
    }
    
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms, faster than 64.30% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 43.2 MB, less than 62.38% of Java online submissions for Diameter of Binary Tree.
     */
    public int diameterOfBinaryTreeUsingRecursion(TreeNode root) {
        if (root == null) return 0;
        
        int left = diameterOfBinaryTreeUsingRecursion(root.left);
        int right = diameterOfBinaryTreeUsingRecursion(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }
}
