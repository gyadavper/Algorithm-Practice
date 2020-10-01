package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int startWindow = 0, matched = 0;
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
            if (matched == charFreqMap.size())
                resultIndices.add(startWindow);
            if (endWindow >= pattern.length() - 1) {
                char leftChar = str.charAt(startWindow++);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0)
                        matched--;
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}
