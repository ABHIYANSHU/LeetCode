package LeetCode;

public class LowestCommonAncestorOfABST {

    /**
     * Time Complexity: O(log n), as each time only half of the tree is passed down
     * Space Complexity: O(1)
     * Runtime: 7 ms, faster than 61.69% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 50 MB, less than 36.82% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }

    /**
     * Time Complexity: O(log n), as each time only half of the tree is passed down
     * Space Complexity: O(1)
     *  Runtime: 7 ms, faster than 61.69% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 50 MB, less than 36.82% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     */
    public TreeNode lowestCommonAncestorUsingLoop(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        
        return root;
    }
}
