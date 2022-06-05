package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

/**
 * 206. 反转链表
 * @url https://leetcode.cn/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    /**
     * 解法1 递归
     * @url https://labuladong.github.io/algo/2/17/17/
     *
     * step1：递归函数 reverseList 的定义：输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     * step2：根据函数定义，reverseList 函数会返回反转之后的头结点，我们用变量 last 表示。
     * step3：设置当前节点的 next 和 父节点的 next
     *
     * 现在再来看下面的代码：
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 解法2 迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
