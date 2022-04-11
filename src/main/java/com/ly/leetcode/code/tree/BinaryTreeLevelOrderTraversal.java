package com.ly.leetcode.code.tree;

import com.ly.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @url https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 解法1：使用多个list 的集合存储每一层的数据，比较暴力和直观的解法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pushNode(root, 0, result);
        return result;
    }

    public void  pushNode(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() == depth){
            result.add(new ArrayList<Integer>());
        }

        result.get(depth).add(root.val);
        pushNode(root.left, depth+1, result);
        pushNode(root.right, depth+1, result);
    }

    /**
     * 解法2：使用队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
