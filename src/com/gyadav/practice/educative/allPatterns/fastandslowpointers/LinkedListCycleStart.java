package com.gyadav.practice.educative.allPatterns.fastandslowpointers;

import com.gyadav.practice.helper.ListNode;

public class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode interSect = interSection(head);
        if (interSect == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = interSect;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static ListNode interSection(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
