package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch: pattern.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(0);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) == 0)
                    matched++;
            }
            if (matched == pattern.length())
                return true;
            if (endWindow >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                windowStart++;
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0)
                        matched--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
    public static void main (String[] a) {
        System.out.println(findPermutation("aaacb", "abc"));
    }
}
