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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null){
            return true;
        }else if(root.left == null || root.right == null){
            return false;
        }else{
            return isSame(root.left, root.right);
        }
    }

    private boolean isSame(TreeNode leftSub,TreeNode rightSub){
        if(leftSub == null && rightSub == null){
            return true;
        }else if(leftSub == null || rightSub == null){
            return false;
        }else{
            if(leftSub.val != rightSub.val){
                return false;
            }else{
                return (isSame(leftSub.left,rightSub.right) && isSame(leftSub.right,rightSub.left));
            }
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