package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

/**
 * 234. 回文链表
 * @url https://leetcode.cn/problems/palindrome-linked-list/
 *
 */
public class PalindromeLinkedList {
    // 左侧指针
    ListNode left;

    /**
     * 解法1：
     * step1：快慢指针寻找中点，注意奇偶的区别
     * step2：头节点和中间节点同时遍历，判断回文链表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     * @url https://labuladong.gitee.io/algo/2/17/19/
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow 指针现在指向链表中点
        // fast 不为 null，则链表长度为奇数，slow 还需要再进一步
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = slow;
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    /**
     * 解法2：后序遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        left = head;
        return traverse(head);
    }

    /**
     * 后序遍历
     * @param right
     * @return
     */
    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean res = traverse(right.next);
        // 后序遍历
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}
