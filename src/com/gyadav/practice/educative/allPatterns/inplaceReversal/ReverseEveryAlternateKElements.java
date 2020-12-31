package com.gyadav.practice.educative.allPatterns.inplaceReversal;

public class ReverseEveryAlternateKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;
        ListNode current = head, previous = null;
        while (true) {
            ListNode lastNodeOfPreviousList = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next = null;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
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
            for (int i = 0; current != null && i < k; i++) {
                previous = current;
                current = current.next;
            }
            if (current == null)
                break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryAlternateKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
