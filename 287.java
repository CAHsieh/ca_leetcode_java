class Solution {
    public int findDuplicate(int[] nums) {
        // easy solution
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] == nums[j])
        //             return nums[i];
        //     }
        // }
        // return -1;


        // seem as cycle list.
        int n = nums.length;
        int slow=n,fast=n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];

        }while(slow != fast);

        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }

        return slow;
    }
}