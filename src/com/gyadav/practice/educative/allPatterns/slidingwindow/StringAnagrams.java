package com.gyadav.practice.educative.allPatterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int startWindow = 0;
        int matched = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for(char c: pattern.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        for(int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if(charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if(matched==charFrequencyMap.size()){
                resultIndices.add(startWindow);
            }
            if(endWindow >= pattern.length() - 1){
                char leftChar = str.charAt(startWindow);
                startWindow++;
                if(charFrequencyMap.containsKey(leftChar)) {
                    if(charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }
}