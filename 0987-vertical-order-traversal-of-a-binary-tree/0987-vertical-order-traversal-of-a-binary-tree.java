class Solution {
    // Helper class to store node with its coordinates
    class Tuple {
        TreeNode node;
        int col;
        int row;

        Tuple(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: col -> (row -> PriorityQueue of node values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int col = tuple.col;
            int row = tuple.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, col - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> subList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    subList.add(nodes.poll());
                }
            }
            list.add(subList);
        }

        return list;
    }
}
