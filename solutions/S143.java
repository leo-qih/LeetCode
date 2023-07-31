package solutions;

import models.ListNode;

/**
 * 143. Reorder List
 */

public class S143 {
    public void reorderList(ListNode head) {
        // find the middle node of the list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second half
        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // merge two lists
        ListNode l1 = head, l2 = prev;
        while (l1 != null && l2 != null) {
            ListNode temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = temp;
        }
    }
}
