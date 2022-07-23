package com.ly.leetcode.code.dp;

/**
 * 53. 最大子数组和
 * @url https://leetcode.cn/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 解法1
     *
     * 重点在于 状态的定义 和 初始值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        //状态定义 以索引cur结尾的子数组的最大和
        int cur = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            cur = cur < 0 ? nums[i] : cur + nums[i];
            max = Math.max(cur, max);
        }

        return max;
    }
}
