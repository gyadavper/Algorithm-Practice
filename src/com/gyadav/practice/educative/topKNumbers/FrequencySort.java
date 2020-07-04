package com.gyadav.practice.educative.topKNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map .Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            maxHeap.add(m);
        }
        StringBuilder sb = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            for (int i = 0; i < maxHeap.peek().getValue(); i++)
                sb.append(maxHeap.peek().getKey());
            maxHeap.poll();
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
