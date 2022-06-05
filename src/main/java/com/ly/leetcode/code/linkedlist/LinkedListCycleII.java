package com.ly.leetcode.code.linkedlist;

import com.ly.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * @url https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    /**
     * 解法1：哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * 解法2：快慢指针
     *
     * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇。
     * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
     *
     *          o-o-o-o
     *          |     |
     *  o-o-o-o-o-o-o-o (相遇点，a=4,b=3)
     *
     *  根据题意，任意时刻，fast 指针走过的距离都为slow 指针的 22 倍。因此，我们有
     *
     * a+(n+1)b+nc=2(a+b) => a=c+(n-1)(b+c)
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     *
     * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     *
     * ps: 为什么慢指针入环第一圈没走完的时候就会和快指针相遇？
     * 假设环的长度为A,慢指针在入环的时候快指针在环中的位置B(取值范围0到A-1),
     * 当快慢指针相遇时 [慢指针在环中走了C] ,有
     *     C % A = ( B + 2C) % A,等价于
     *     An + C = B + 2C,合并得
     *     C = An - B
     *     当 n=1 时 , 0 <= C < A
     * 故 慢指针在第一圈必定能和快指针相遇
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            // 判断 slow 和 fast 是否相遇
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
