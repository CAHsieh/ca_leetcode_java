class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null)
            return 0;

        int e = -2, s = -1, max = nums[0], min = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);

            if(max > nums[i]){
                e = i;
            }

            if(min < nums[nums.length - i - 1]){
                s = nums.length - i - 1;
            }
        }

        return e - s + 1;
    }
}