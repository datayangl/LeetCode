package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * @url https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    long pre = Long.MIN_VALUE;

    /**
     * 解法1：中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST1(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST1(root.right);
    }

    /**
     * 解法2：递归
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean isValidBST2(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return help(node.left, lower, node.val) && help(node.right, node.val, upper);
    }

    public boolean help(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return help(node.left, lower, node.val) && help(node.right, node.val, upper);
    }

}
