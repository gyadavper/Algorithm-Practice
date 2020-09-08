package com.gyadav.practice.educative.kWayMerge;

import java.util.List;
import java.util.PriorityQueue;

class Node {
    int elementIndex;
    int arrayIndex;

    public Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);
        for (int i = 0; i < lists.size(); i++)
            if (lists.get(i) != null)
                minHeap.add(new Node(0, i));

        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            result = lists.get(current.arrayIndex)[current.elementIndex];
            if (++numberCount == k)
                break;
            current.elementIndex++;
            if (lists.get(current.arrayIndex).length > current.elementIndex)
                minHeap.add(current);
        }
        return result;
    }
}
