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

    public int rob(TreeNode root) {
        // easy solution
        // if (null == root)
        //     return 0;
        // int val = 0;
        // if (root.left != null) 
        //     val += rob(root.left.left) + rob(root.left.right);
        // if (root.right != null) 
        //     val += rob(root.right.left) + rob(root.right.right);
        // return Math.max(root.val + val, rob(root.left) + rob(root.right));
        int[] res = rubSub(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * DP solution
     * res[0]儲存的是自己及下兩階最大值的加總
     * res[1]儲存的是不含自己的兩子樹加總
     */
    private int[] rubSub(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;

        int[] left = rubSub(root.left);
        int[] right = rubSub(root.right);

        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
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