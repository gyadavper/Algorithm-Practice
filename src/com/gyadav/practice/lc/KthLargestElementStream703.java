package com.gyadav.practice.lc;

import java.util.PriorityQueue;

public class KthLargestElementStream703 {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargestElementStream703(int k, int[] nums) {
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        this.k = k;
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k)
            minHeap.offer(val);
        else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
