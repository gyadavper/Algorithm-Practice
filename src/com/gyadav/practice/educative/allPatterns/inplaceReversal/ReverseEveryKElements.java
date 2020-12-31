package com.gyadav.practice.educative.allPatterns.inplaceReversal;

public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k <=1 || head == null) {
            return head;
        }
        ListNode previous = null, current = head;
        while (true) {
            ListNode lastNodeOfPreviousList = previous;
            ListNode lastNodeOfSubList = current;
            for (int i = 0; current != null && i < k; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (lastNodeOfPreviousList == null) {
                head = previous;
            } else {
                lastNodeOfPreviousList.next = previous;
            }
            lastNodeOfSubList.next = current;
            if (current==null){
                break;
            }
            previous = lastNodeOfSubList;
        }
        return head;
    }
}
