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
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.val <= sum) {
            ans = isMatch(root, sum);
        }
        if (root.left != null)
            ans += pathSum(root.left, sum);
        if (root.right != null)
            ans += pathSum(root.right, sum);
        return ans;
    }

    private int isMatch(TreeNode node, int sum) {
        if (node == null)
            return 0;
        if (sum > node.val) {
            return 0;
        } else if (sum == node.val) {
            return 1;
        } else {
            return (isMatch(node.left, sum - node.val) + isMatch(node.right, sum - node.val));
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}