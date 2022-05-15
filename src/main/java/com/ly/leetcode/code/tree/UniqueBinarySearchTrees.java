package com.ly.leetcode.code.tree;

/**
 * 96. 不同的二叉搜索树
 * @url https://leetcode.cn/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n < 2) return n;
        int[] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n ; ++i) {
            for (int j = 1; j <= i; ++j) {
                nums[i] += nums[j-1] * nums[i-j];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
       new  UniqueBinarySearchTrees().numTrees(10);
    }
}


