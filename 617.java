/* *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode newNode = new TreeNode(t1.val + t2.val);

        // merge Left
        if (t1.left != null && t2.left != null) {
            newNode.left = mergeTrees(t1.left, t2.left);
        } else {
            newNode.left = t1.left == null ? t2.left : t1.left;
        }

        //merge Right
        if (t1.right != null && t2.right != null) {
            newNode.right = mergeTrees(t1.right, t2.right);
        } else {
            newNode.right = t1.right == null ? t2.right : t1.right;
        }

        return newNode;
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