package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 114. 二叉树展开为链表
 * @url https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {
    /**
     * 解法1
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) return;

        flatten1(root.left);
        flatten1(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 解法2
     * @param root
     */
    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;

                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
