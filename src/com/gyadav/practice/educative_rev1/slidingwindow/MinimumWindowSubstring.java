package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int matched = 0, startWindow = 0, minWindowSize = Integer.MAX_VALUE;
        int[] arr = {0, 0};
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) == 0)
                    matched++;
            }
            while (matched == charFreqMap.size()) {
                if (minWindowSize > endWindow - startWindow + 1) {
                    minWindowSize = endWindow - startWindow + 1;
                    arr[0] = startWindow;
                    arr[1] = endWindow;
                }
                char leftChar = str.charAt(startWindow++);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0)
                        matched--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return arr[0] == 0 && arr[1] == 0? "" : str.substring(arr[0], arr[1] + 1);
    }
}
