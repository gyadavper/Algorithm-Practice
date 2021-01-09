package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int startWindow = 0, maxSub = 0;
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char currentChar = str.charAt(endWindow);
            charFreqMap.put(currentChar, charFreqMap.getOrDefault(currentChar, 0) + 1);

            while (charFreqMap.size() > k) {
                char oldChar = str.charAt(startWindow);
                startWindow++;
                charFreqMap.put(oldChar, charFreqMap.get(oldChar) - 1);
                if (charFreqMap.get(oldChar) == 0)
                    charFreqMap.remove(oldChar);
            }
            maxSub = Math.max(maxSub, endWindow - startWindow + 1);
        }
        return maxSub;
    }
}
