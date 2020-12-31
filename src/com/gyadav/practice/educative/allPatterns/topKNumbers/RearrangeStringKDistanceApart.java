package com.gyadav.practice.educative.allPatterns.topKNumbers;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static String reorganizeString(String str, int k) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : str.toCharArray())
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        maxHeap.addAll(charFreqMap.entrySet());
        StringBuilder sb = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.offer(current);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> previous = queue.poll();
                if (previous.getValue() > 0)
                    maxHeap.add(previous);
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}
