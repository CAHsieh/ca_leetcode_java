/**
 * 與最佳解相比
 * 0的判斷太繁瑣
 * 但空間較節省
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;
        int sum = 1,zeroCount=0,zeroIdx;
        if(nums[0] == 0){
            zeroCount=1;
            zeroIdx=0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0)
                sum*=nums[i];
            else{
                zeroIdx = i;
                zeroCount++;
            }
        }

        if(zeroCount > 1)
            return new int[nums.length];

        int k = nums[0];
        if (zeroCount == 0) {
            nums[0] = sum;
            for(int i=1;i<nums.length;i++){
                nums[i] = (sum / nums[i])*k;
            }
        }else{
            nums[0] = nums[0] == 0 ? sum : 0;
            for(int i=1;i<nums.length;i++){
                if(nums[i] == 0){
                    nums[i] = sum*k;
                }else{
                    nums[i] = 0;
                }
            }
        }
        return nums;
    }
}