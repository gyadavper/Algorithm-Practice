package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.HashMap;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, length = 0;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            charFreqMap.put(arr[windowEnd], charFreqMap.getOrDefault(arr[windowEnd], 0) + 1);
            while (charFreqMap.size() > 2) {
                char removeChar = arr[windowStart];
                windowStart ++;
                charFreqMap.put(removeChar, charFreqMap.get(removeChar) - 1);
                if (charFreqMap.get(removeChar) == 0)
                    charFreqMap.remove(removeChar);
            }
            length = Math.max(length, windowEnd - windowStart + 1);
        }
        return length;
    }
}
