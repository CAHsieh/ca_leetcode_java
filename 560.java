import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // System.out.println(sol.subarraySum(new int[] { 1, 2, 3 }, 3));
        // System.out.println(sol.subarraySum(new int[] { 1, 2, 3, 2 }, 3));
        // System.out.println(sol.subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println(sol.subarraySum(new int[] { -1, 2, 1 }, 0));
    }

    public int subarraySum(int[] nums, int k) {
        if (null == nums)
            return 0;
        int count = 0;

        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(0,1);

        int current = 0;
        for (int n : nums) {
            current += n;
            if (record.containsKey(current-k)) {
                count += record.get(current-k);
            }
            record.put(current, record.getOrDefault(current, 0) + 1);
        }

        return count;
    }
}