package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * #url https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int left = getNum(root.left);

        if (left == k - 1) {
            return root.val;
        } else if (left < (k -1)) {
            return kthSmallest(root.right, k - left -1 );
        } else {
            return kthSmallest(root.left, k);
        }
    }

    public int getNum(TreeNode root) {
        if (root == null) return 0;

        int left = getNum(root.left);
        int right = getNum(root.right);

        return left + right + 1;
    }
}
