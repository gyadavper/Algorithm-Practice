package com.gyadav.practice.educative.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("ADOBECODEBANC", "ABC"));
    }

    public static String findSubstring(String str, String pattern) {
        int startWindow = 0;
        int minimumLength = str.length() + 1;
        int subStringStart = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int matched = 0;
        for (char c : pattern.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if (frequencyMap.containsKey(rightChar)) {
                frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
                if (frequencyMap.get(rightChar) >= 0) {
                    matched++;
                }
            }
            while (matched == pattern.length()) {
                if (minimumLength > (endWindow - startWindow) + 1) {
                    minimumLength = (endWindow - startWindow) + 1;
                    subStringStart = startWindow;
                }
                char leftChar = str.charAt(startWindow);
                startWindow++;
                if (frequencyMap.containsKey(leftChar)) {
                    if (frequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
                }
            }
        }
        return minimumLength > str.length() ? "" : str.substring(subStringStart, subStringStart + minimumLength);
    }
}
