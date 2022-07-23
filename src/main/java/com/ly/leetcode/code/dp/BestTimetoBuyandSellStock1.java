package com.ly.leetcode.code.dp;

/**
 * 121. 买卖股票的最佳时机
 * @url https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock1 {
    /**
     * 解法1
     *
     * 状态定义 dp[n][2] => n 第几天，2 表示两种状态（0 未持有股票， 1 持有股票）
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // 状态定义
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = - prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        return dp[n-1][0];
    }
}
