package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.HashMap;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int startWindow = 0, maxLength = 0, maxRepChar = 0;
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            maxRepChar = Math.max(maxRepChar, charFreqMap.get(rightChar));
            if (endWindow - startWindow + 1 - maxRepChar > k) {
                char leftChar = str.charAt(startWindow);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                startWindow++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }
        return maxLength;
    }
}
