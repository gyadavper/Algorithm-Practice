package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int windowStart = 0, windowSize = Integer.MIN_VALUE;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currentChar = str.charAt(windowEnd);
            charFreqMap.put(currentChar, charFreqMap.getOrDefault(currentChar, 0) + 1);
            while (charFreqMap.size() >= k) {
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                windowStart++;
            }
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}
