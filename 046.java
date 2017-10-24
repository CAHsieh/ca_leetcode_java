import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> list;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(),0);
        return list;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> pack,int depth) {
        if(depth == nums.length-1){
            list.add(new ArrayList<>(pack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                pack.add(nums[i]);
                used[i] = true;
                dfs(nums,used,pack,depth+1);
                pack.remove(depth);
                used[i] = false;
            }
        }
    }
}