package com.gyadav.practice.lc;

import com.gyadav.practice.helper.ListNode;

import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode root : lists)
            minHeap.offer(root);

        ListNode head = null, tail = null;
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            if (head == null) {
                head = current;
            } else {
                tail.next = current;
            }
            tail = current;
            if (current.next != null)
                minHeap.offer(current.next);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergekSortedLists23.mergeKLists(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
