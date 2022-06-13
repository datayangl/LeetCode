package com.ly.leetcode.code.dp;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * @url https://leetcode.cn/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    /**
     * 解法1：dp
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     *
     * step1: base case：dp[i] 初始值为 1，因为以 nums[i] 结尾的最长递增子序列起码要包含它自己。
     * step2: 状态定义
     * step3：状态转移方程
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 解法2：dp + 二分查找
     *
     * 原理涉及到 patience sorting 算法，证明略。
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}