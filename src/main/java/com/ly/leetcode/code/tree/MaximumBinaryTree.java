package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 654. 最大二叉树
 * @url https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findMax(nums, 0, nums.length);
    }

    public TreeNode findMax(int[] nums, int start, int end) {
        if (start == end) return null;
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = findMax(nums, start, index);
        root.right = findMax(nums, index+1, end);

        return root;
    }
}
