package com.gyadav.practice.educative.kWayMerge;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> matrix[a.arrayIndex][a.elementIndex] - matrix[b.arrayIndex][b.elementIndex]);
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));
        int count = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            result = matrix[current.arrayIndex][current.elementIndex];
            if (++count == k)
                break;
            current.elementIndex++;
            if (matrix[current.arrayIndex].length > current.elementIndex)
                minHeap.add(current);
        }
        return result;
    }
}
