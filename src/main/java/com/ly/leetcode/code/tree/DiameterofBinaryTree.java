package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 543. 二叉树的直径
 * @url https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 核心思路：首先单独分析一个节点(TreeNode) 要求当前节点的最大直径，它要做什么事情？
 * 它的最大深度 = 左节点的最大深度 + 右节点的最大深度 + 1(自身节点深度)
 * 它的最大直径(包含自身) = 左节点的最大深度 + 右节点的最大深度 + 1
 * 递归求最大深度的过程不断更新最大直径。需要注意的是最终返回结果 -1，不包括根节点
 *
 */
public class DiameterofBinaryTree {
    int ans;

    /**
     * 解法1
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);
        return ans-1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        ans = Math.max(ans, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
