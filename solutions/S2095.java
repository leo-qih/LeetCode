package solutions;

import models.ListNode;

/**
 * 2095. Delete the Middle Node of a Linked List
 */

public class S2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead, slow = dummyHead, fast = dummyHead;

        while (fast != null) {
            pre = slow;
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else fast = fast.next;
        }
        pre.next = slow.next;

        return dummyHead.next;
    }
}
