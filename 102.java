import java.util.ArrayList;
import java.util.HashMap;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, ans, root);
        return ans;
    }

    private void dfs(int depth, List<List<Integer>> list, TreeNode node) {
        if (node == null)
            return;

        List<Integer> currentLevelList;
        if (depth >= list.size())
            currentLevelList = new ArrayList<>();
        else
            currentLevelList = list.get(depth);

        currentLevelList.add(node.val);
        if (depth >= list.size())
            list.add(currentLevelList);

        dfs(depth + 1, list, node.left);
        dfs(depth + 1, list, node.right);
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