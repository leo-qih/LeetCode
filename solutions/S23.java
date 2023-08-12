package solutions;

import java.util.PriorityQueue;

import models.ListNode;

/**
 * 23. Merge k Sorted Lists
 */

public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            cur.next = p;
            cur = cur.next;
            if (p.next != null) pq.offer(p.next);
        }

        return dummyHead.next;

        // if (lists.length == 0) return null;

        // return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];

        int mid = lo + (hi - lo) / 2;
        ListNode left = merge(lists, lo, mid);
        ListNode right = merge(lists, mid + 1, hi);

        return merge2List(left, right);
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}
