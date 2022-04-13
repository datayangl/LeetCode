package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 226. 翻转二叉树
 * @url https://leetcode-cn.com/problems/invert-binary-tree/
 * 后序遍历思想
 */
public class InvertBinaryTree {
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
