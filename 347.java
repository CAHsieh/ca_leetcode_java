import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int times = countMap.getOrDefault(nums[i], 0) + 1;
            countMap.put(nums[i], times);
        }

        List<Integer> ans = new ArrayList<>();

        for (int key : countMap.keySet()) {
            int insertIdx = ans.size();

            for (int i = 0; i < ans.size(); i++) {
                if (countMap.get(ans.get(i)) < countMap.get(key)) {
                    insertIdx = i;
                    break;
                }
            }
            ans.add(insertIdx, key);
            if (ans.size() > k)
                ans.remove(k);
        }

        return ans;
    }
}