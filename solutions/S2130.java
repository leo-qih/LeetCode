package solutions;

import models.ListNode;

/**
 * 2130. Maximum Twin Sum of a Linked List
 */

public class S2130 {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHaed = reverseList(slow.next);

        ListNode p1 = head, p2 = reversedHaed;
        int maxSum = 0;
        while (p1 != null && p2 != null) {
            maxSum = Math.max(maxSum, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxSum;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
