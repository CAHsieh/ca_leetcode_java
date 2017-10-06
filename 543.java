/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = dfs(root.left, 0);
        int rightDepth = dfs(root.right, 0);
        int leftMax = 0, rightMax = 0;
        if (root.left != null)
            leftMax = diameterOfBinaryTree(root.left);
        if (root.right != null)
            rightMax = diameterOfBinaryTree(root.right);
        int subMax = Math.max(leftMax, rightMax);
        return Math.max(subMax, leftDepth + rightDepth);
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}