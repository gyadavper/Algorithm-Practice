package com.gyadav.practice.educative.allPatterns.topKNumbers;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
    int k;
    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for (int i = 0; i < nums.length; i++)
            add(nums[i]);
    }

    public int add(int num) {
        minHeap.add(num);
        if (minHeap.size() > k)
            minHeap.poll();
        return minHeap.peek();
    }
}
