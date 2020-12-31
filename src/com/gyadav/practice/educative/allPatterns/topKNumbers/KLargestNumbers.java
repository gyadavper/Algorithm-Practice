package com.gyadav.practice.educative.allPatterns.topKNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        for (int i = 0; i < k; i++)
            minHeap.add(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
