/**
 * DP題
 * 可能空一格或空兩格
 */
class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;

        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i-2 >= 0){
                if(i-3 >= 0)
                    nums[i] += Math.max(nums[i-3],nums[i-2]);
                else
                    nums[i] += nums[i-2];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}