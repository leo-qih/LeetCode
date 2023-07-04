package solutions;

import models.ListNode;

/**
 * 445. Add Two Numbers II
 */

 class S445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), p = dummyHead;
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
           if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
        }

        return reverseList(dummyHead.next);
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