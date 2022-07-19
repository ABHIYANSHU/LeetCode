package LeetCode;

public class SameTree {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 41.6 MB, less than 49.67% of Java online submissions for Same Tree.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null && q != null) || (p != null && q == null))
            return false;
        
        if (p.val != q.val)
            return false;
        
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        
        return left && right;
    }
}