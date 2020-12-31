package com.gyadav.practice.educative.allPatterns.fastandslowpointers;

import com.gyadav.practice.helper.ListNode;

public class MiddleOfLinkedList {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
