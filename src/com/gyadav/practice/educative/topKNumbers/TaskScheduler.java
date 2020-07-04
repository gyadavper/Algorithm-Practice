package com.gyadav.practice.educative.topKNumbers;

import java.util.*;

public class TaskScheduler {
    public static int scheduleTasks(char[] tasks, int k) {
        int intervalCount = 0;
        Map<Character, Integer> charFreqCount = new HashMap<>();
        for (char c : tasks)
            charFreqCount.put(c, charFreqCount.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(charFreqCount.entrySet());
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n = k + 1;
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                intervalCount++;
                Map.Entry<Character, Integer> current = maxHeap.poll();
                if (current.getValue() > 1) {
                    current.setValue(current.getValue() - 1);
                    waitList.add(current);
                }
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty())
                intervalCount += n;
        }
        return intervalCount;
    }
}
