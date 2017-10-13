class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null) return 0;
        int current = nums.length >=0?nums[0]:0 , max = nums.length >=0?nums[0]:0;
        for(int i=1;i<nums.length;i++){
            current = Math.max(current+nums[i],nums[i]);
            max = Math.max(max,current);
        }
        return max;
    }
}