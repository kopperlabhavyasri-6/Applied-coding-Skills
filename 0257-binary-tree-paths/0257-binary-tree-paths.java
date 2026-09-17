class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        // Append current node's value
        path += node.val;

        // If it's a leaf node, add the complete path to the list
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // Continue DFS on non-null children with "->" arrow
        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }
        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }
}