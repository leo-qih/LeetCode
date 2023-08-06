package solutions;

import models.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */

public class S24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead, cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
            prev = cur;
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
