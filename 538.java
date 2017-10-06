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
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convert(root, 0);

        return root;
    }

    private int convert(TreeNode node, int num) {
        if (node == null) return num;

        int right = convert(node.right, num);
        int left = convert(node.left, node.val+right);

        node.val+=right;
        return left; //<-important!!!!
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