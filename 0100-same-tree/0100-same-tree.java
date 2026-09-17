class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both nodes are null, trees are identical so far
        if (p == null && q == null) {
            return true;
        }
        
        // If only one node is null, or their values don't match, they aren't identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}