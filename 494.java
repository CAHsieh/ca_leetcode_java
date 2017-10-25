/**
 * DP Solution
 * 
 * one provement:
 * target = sum(P) - sum(N)
 * target + sum(P) + sum(N) = sum(P) - sum(N) + sum(P) + sum(N)
 * target + SUM = 2 * sum(P)
 * 2 * sum(P) = target + SUM
 * sum(P) = (target + SUM)/2
 * 
 */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        return sum < S || (S + sum) % 2 != 0 ? 0 : findWays(nums, (S + sum) / 2);
    }

    /**
     * dp array為記錄加總數量
     */
    private int findWays(int[] nums, int sumP) {
        int[] dp = new int[sumP + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = sumP; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }

        return dp[sumP];
    }
}
// easy Solution
// class Solution {
//     int ans;
//     public int findTargetSumWays(int[] nums, int S) {
//         ans = 0;
//         dfs(0, nums, -S);
//         return ans;
//     }
//     private void dfs(int i, int[] nums, int S) {
//         if (i == nums.length) {
//             if (S == 0)
//                 ans++;
//             return;
//         }
//         dfs(i + 1, nums, S + nums[i]);
//         dfs(i + 1, nums, S - nums[i]);
//     }
// }