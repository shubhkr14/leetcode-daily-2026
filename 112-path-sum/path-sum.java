import java.util.*;
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currSum = sums.pop();
            if (node.left == null && node.right == null && currSum == targetSum)
                return true;
            if (node.right != null) {
                stack.push(node.right);
                sums.push(currSum + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(currSum + node.left.val);
            }
        }
        return false;
    }
}