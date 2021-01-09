package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    public static int findLength(String str) {
        int startWindow = 0, windowLen = 0;
        Map<Character, Integer> charPosMap = new HashMap<>();
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if (charPosMap.containsKey(rightChar)) {
                startWindow = Math.max(startWindow ,charPosMap.get(rightChar) + 1);
            }
            charPosMap.put(rightChar, endWindow);
            windowLen = Math.max(windowLen, endWindow - startWindow + 1);
        }
        return windowLen;
    }
    public static void main (String[] a) {
        System.out.println(findLength("abba"));
    }
}
