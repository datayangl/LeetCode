package com.ly.leetcode.code.dp;

/**
 * 70. 爬楼梯
 * @url https://leetcode.cn/problems/climbing-stairs/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int p1 = 1;
        int p2 = 1;
        int cur = 0;
        for (int i = 1; i < n; i++) {
            cur = (p1 + p2) % 1000000007;
            p1 = p2;
            p2 = cur;
        }
        return cur;
    }
}
