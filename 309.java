/**
 * 簡化版後的節省空間。
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0)
            return 0;

        int prev_buy = 0, prev_sell = 0, sell = 0, buy = Integer.MIN_VALUE;

        for (int p : prices) {
            prev_buy = buy;
            buy = Math.max(prev_buy, prev_sell - p);
            prev_sell = sell;
            sell = Math.max(prev_sell, prev_buy + p);
        }

        return sell;
    }
}

//簡化版
// class Solution {
//     public int maxProfit(int[] prices) {
//         if (null == prices || prices.length == 0)
//             return 0;
//         int[] buy = new int[prices.length + 1];
//         int[] sell = new int[prices.length + 1];
//         buy[0] = sell[0] = 0;
//         buy[1] = -prices[0];
//         sell[1] = 0;

//         for (int i = 2; i <= prices.length; i++) {
//             buy[i] = Math.max(sell[i - 2] - prices[i - 1], buy[i - 1]);
//             sell[i] = Math.max(buy[i - 1] + prices[i - 1], sell[i - 1]);
//         }

//         return sell[prices.length];
//     }
// }

// 起始
// class Solution {
//     public int maxProfit(int[] prices) {
//         if(null == prices || prices.length == 0) return 0;
//         int max = 0;
//         int[] buy = new int[prices.length];
//         int[] sell = new int[prices.length];
//         int[] cooldown = new int[prices.length];
//         buy[0] = -prices[0];
//         sell[0] = 0;
//         cooldown[0] = 0;

//         for (int i = 1; i < prices.length; i++) {
//             buy[i] = Math.max(cooldown[i - 1] - prices[i], buy[i - 1]);
//             sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
//             cooldown[i] = Max(buy[i - 1], sell[i - 1], cooldown[i - 1]);
//         }

//         int l = prices.length - 1;
//         max = Max(buy[l], sell[l], cooldown[l]);

//         return max;
//     }

//     private int Max(int... param) {
//         int max = param[0];
//         for (int i = 1; i < param.length; i++) {
//             if (max < param[i])
//                 max = param[i];
//         }
//         return max;
//     }
// }