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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean isSub = false;
        if (s.val == t.val) {
            isSub = compare(s, t);
        }

        if (!isSub) {
            if (s.left != null)
                isSub = isSubtree(s.left, t);
            if (!isSub && s.right != null)
                isSub = isSubtree(s.right, t);
        }

        return isSub;
    }

    private boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else {
            return compare(s.left, t.left) && compare(s.right, t.right) && s.val == t.val;
        }

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