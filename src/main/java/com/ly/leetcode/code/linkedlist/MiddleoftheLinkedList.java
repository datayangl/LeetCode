package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

/**
 * 876. 链表的中间结点
 * @url https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class MiddleoftheLinkedList {
    /**
     * 解法1 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
