package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.HashMap;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int startWindow = 0, windowLength = 0;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int endWindow = 0; endWindow < str.length(); endWindow++){
            char currentChar = str.charAt(endWindow);
            charFreqMap.put(currentChar, charFreqMap.getOrDefault(currentChar,0) + 1);
            while (charFreqMap.get(currentChar) > 1) {
                char  removeChar = str. charAt(startWindow);
                startWindow++;
                charFreqMap.put(removeChar, charFreqMap.get(removeChar) - 1);
                if (charFreqMap.get(removeChar) == 0)
                    charFreqMap.remove(removeChar);
            }
            windowLength = Math.max(windowLength, endWindow - startWindow + 1);
        }
        return windowLength;
    }
}
