package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int startWindow = 0, maxRepSoFar = 0, windowLen = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            maxRepSoFar = Math.max(maxRepSoFar, charFreqMap.get(rightChar));
            if ((endWindow - startWindow + 1) - maxRepSoFar > k) {
                char leftChar = str.charAt(startWindow);
                startWindow++;
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0)
                    charFreqMap.remove(leftChar);
            }
            windowLen = Math.max(windowLen, endWindow - startWindow + 1);
        }
        return windowLen;
    }
}
