package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

/**
 * 141. 环形链表
 * @url https://leetcode.cn/problems/linked-list-cycle/
 *
 */
public class LinkedListCycle {
    /**
     * 解法1：快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)  return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
