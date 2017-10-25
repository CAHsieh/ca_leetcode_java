import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.subsets(new int[]{1,2,3});
    }

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {

        ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            dfs(i, nums, new ArrayList<>());
        }

        return ans;
    }

    private void dfs(int i, int[] nums, List<Integer> list) {
        list.add(nums[i]);
        ans.add(new ArrayList<>(list));
        for (int j = i + 1; j < nums.length; j++) {
            dfs(j, nums, list);
            list.remove(list.size()-1);
        }
    }
}