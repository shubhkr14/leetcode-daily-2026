class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));   // ignore negative
        int right = Math.max(0, dfs(node.right)); // ignore negative

        // path passing through current node
        int current = node.val + left + right;

        maxSum = Math.max(maxSum, current);

        // return max path extending upwards
        return node.val + Math.max(left, right);
    }
}