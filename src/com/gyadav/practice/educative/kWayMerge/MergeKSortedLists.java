package com.gyadav.practice.educative.kWayMerge;

import java.util.PriorityQueue;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}
public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.value - b.value);
        for (ListNode list : lists)
            if (list !=null)
                minHeap.add(list);

        ListNode head = null, current = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (head == null) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
            if (node.next != null)
                minHeap.add(node.next);
        }
        return head;
    }
}
