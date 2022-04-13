package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * @url https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) return root;
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node left, Node right) {
        if (left == null || right == null) return;

        left.next = right;

        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
