package com.ly.leetcode.code.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @url https://leetcode.cn/problems/coin-change/
 *
 */
public class CoinChange {
    int[] memo;

    /**
     * 解法1：带备忘录的 dp解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，表示还未被计算
        Arrays.fill(memo, -10);
        return dp(coins, amount);
    }

    int dp(int[] coins, int n) {
        // base case
        if (n == 0) return 0;
        if (n < 0) return -1;

        if (memo[n] != -10) return memo[n];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = dp(coins, n - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        // 把计算结果存入备忘录
        memo[n] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[n];
    }

    /**
     * 解法2：dp数组的迭代解法
     * 自底向上使用 dp table 来消除重叠子问题
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        /**
         * 为啥 dp 数组中的值都初始化为 amount + 1？
         * 因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
         *
         * 为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？
         * 因为后面有 dp[i - coin] + 1，这就会导致整型溢出。
         */
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
