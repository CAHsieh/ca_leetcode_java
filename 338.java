/**
 * DP problem
 * 以2的次方為分界點
 * 到下個分界點（2^(n+1))之間的值
 * 為1~(2^n)-1的答案+1
 * 程式碼可在精簡
 */
class Solution {
    public int[] countBits(int num) {
        if(num < 2){
            switch (num) {
                case 0:
                return new int[]{0};      
                default:
                return new int[]{0,1};
            }
        }
        int[] ans = new int[num+1];
        ans[0] = 0;
        ans[1] = 1;

        int threshold = 2;
        int dpVal=1;

        for(int i=2;i<=num;i++){
            if(i == threshold){
                ans[i] = 1;
                dpVal =1;
                threshold <<= 1;
            }else{
                ans[i] = ans[dpVal++]+1;
            }
        }
        return ans;
    }
}