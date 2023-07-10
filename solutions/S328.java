package solutions;

import models.ListNode;

/**
 * 328. Odd Even Linked List
 */

public class S328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode evenHead = head.next, odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
