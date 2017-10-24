import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode node,List<Integer> list){
        if(null!=node.left){
            traversal(node.left,list);
        }
        list.add(node.val);
        if(null != node.right)
            traversal(node.right,list);
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