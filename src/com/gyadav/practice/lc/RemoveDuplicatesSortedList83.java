package com.gyadav.practice.lc;

import com.gyadav.practice.helper.ListNode;
/*Given a sorted linked list, delete all duplicates such that each element appear only once.

        Example 1:

        Input: 1->1->2
        Output: 1->2
        Example 2:

        Input: 1->1->2->3->3
        Output: 1->2->3*/

public class RemoveDuplicatesSortedList83 {
    public static void main(String[] args) {
        RemoveDuplicatesSortedList83 removeDuplicatesSortedList83 = new RemoveDuplicatesSortedList83();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
