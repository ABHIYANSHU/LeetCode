package LeetCode;

public class MaximumDepthOfBinaryTree {

    /**
     * Time Complexity: O(n), as each node is only visited once
     * Space Complexity: O(1), no new object is created
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 42.8 MB, less than 69.68% of Java online submissions for Maximum Depth of Binary Tree.
     */
    public int maxDepthUsingRecursion(TreeNode root) {
        if (root == null)
            return 0;
    
        return 1 + Math.max(maxDepthUsingRecursion(root.left), maxDepthUsingRecursion(root.right));
    }
}