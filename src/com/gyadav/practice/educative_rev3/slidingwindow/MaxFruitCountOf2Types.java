package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int startWindow = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            char rightChar = arr[endWindow];
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            while (charFreqMap.size() > 2) {
                char leftChar = arr[startWindow];
                startWindow++;
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0)
                    charFreqMap.remove(leftChar);
            }
            windowLength = Math.max(windowLength, endWindow - startWindow + 1);
        }
        return windowLength;
    }
}
