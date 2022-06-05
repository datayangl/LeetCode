package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * @url https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 */
public class MergekSortedLists {
    /**
     * 解法1
     *
     * 时间复杂度：O(Nlogk)
     * 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }

        return dummy.next;
    }
}
