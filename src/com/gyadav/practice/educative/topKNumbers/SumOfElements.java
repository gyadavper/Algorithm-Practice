package com.gyadav.practice.educative.topKNumbers;

import java.util.PriorityQueue;

public class SumOfElements {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        for (int i = 0; i < nums.length; i++)
            minHeap.add(nums[i]);
        for (int i = 0; i < k1; i++)
            minHeap.poll();
        int sum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++)
            sum += minHeap.poll();
        return sum;
    }
}
