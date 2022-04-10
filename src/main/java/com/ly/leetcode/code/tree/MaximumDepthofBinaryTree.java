package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 104
 * @url https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 核心思路：首先单独分析一个节点(TreeNode) 要求当前节点的最大深度，它要做什么事情？
 * 这个节点的最大深度即左右子节点的最大深度的较大值 + 自身节点深度(即1)，将这一步抽象成一个函数，然后让root 节点向下递归即可。
 * 需要注意的是边界处理，即递归到叶子节点即 root == null 时，返回0。
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
