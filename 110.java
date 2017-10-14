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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (Math.abs(findDepth(root.left, 1) - findDepth(root.right, 1)) <= 1) {
                return (isBalanced(root.left) && isBalanced(root.right));
            } else {
                return false;
            }
        }
    }

    private int findDepth(TreeNode node, int depth) {
        if (node == null)
            return depth;
        return Math.max(findDepth(node.left, depth + 1), findDepth(node.right, depth + 1));
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