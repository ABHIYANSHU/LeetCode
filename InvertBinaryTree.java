package LeetCode;

public class InvertBinaryTree {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n), function stack, O(1) for in-place
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     * Memory Usage: 41.3 MB, less than 74.43% of Java online submissions for Invert Binary Tree.
     */
    public TreeNode invertTreeUsingRecursion(TreeNode root) {
        if (root == null)
            return null;
                
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTreeUsingRecursion(root.left);
        invertTreeUsingRecursion(root.right);
        
        return root;
    }
}