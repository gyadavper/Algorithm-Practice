package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int startWindow = 0, matched = 0, windowSize = Integer.MAX_VALUE, start = 0, end = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) >= 0)
                    matched++;
            }
            while (matched == pattern.length()) {
                if (windowSize > endWindow - startWindow + 1) {
                    start = startWindow;
                    end = endWindow;
                    windowSize = endWindow - startWindow + 1;
                }
                char leftChar = str.charAt(startWindow++);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0)
                        matched--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return windowSize == Integer.MAX_VALUE ? "" : str.substring(start, end + 1);
    }

    public static void main (String[] a) {
        System.out.println(MinimumWindowSubstring.findSubstring("aa","aa"));
    }
}
