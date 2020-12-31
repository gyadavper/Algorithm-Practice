package com.gyadav.practice.educative.allPatterns.topKNumbers;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }
}
