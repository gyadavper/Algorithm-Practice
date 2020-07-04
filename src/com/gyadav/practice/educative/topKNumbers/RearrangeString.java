package com.gyadav.practice.educative.topKNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public static String rearrangeString(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freqMap.entrySet());
        Map.Entry<Character, Integer> previous = null;
        StringBuilder sb = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            if (previous != null && previous.getValue() > 0)
                maxHeap.add(previous);
            current.setValue(current.getValue() - 1);
            previous = current;
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
