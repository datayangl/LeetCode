package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 * @url https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class IntersectionofTwoLinkedLists {
    /**
     * 解法1 双指针
     * <p>
     * 空间复杂度 O(1)
     * 时间复杂度 O(m+n)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;

        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }

        return n1;
    }

    /**
     * 解法2 哈希表
     *
     * 空间复杂度 O(m)
     * 时间复杂度 O(m+n)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;

    }
}