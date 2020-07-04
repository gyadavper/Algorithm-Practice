package com.gyadav.practice.educative.topKNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> m : freqMap.entrySet()) {
            minHeap.add(m);
        }
        while (!minHeap.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> currentValue = minHeap.poll();
            if (currentValue.getValue() == 1)
                max++;
            else {
                int value = currentValue.getValue();
                while (value != 1) {
                    value--;
                    k--;
                }
                if (k >= 0)
                    max++;
            }
        }
        while (k > 0) {
            max--;
            k--;
        }
        return max;
    }
    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
