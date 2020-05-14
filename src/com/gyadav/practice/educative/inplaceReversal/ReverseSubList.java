package com.gyadav.practice.educative.inplaceReversal;

public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p==q)
            return head;
        ListNode previous = null;
        ListNode current = head;
        for (int i = 0; current!=null && i < (p-1); i++) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSublist = current;
        ListNode next = null;
        for (int i = 0; current != null && i <(q -p) + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }
        lastNodeOfSublist.next = current;
        return head;
    }
}
