package com.gyadav.practice.lcChallenge;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charFreqMap.containsKey(currentChar)) {
                int removeTill = charFreqMap.get(currentChar);
                while (start <= removeTill) {
                    charFreqMap.remove(s.charAt(start));
                    start++;
                }
            }
                charFreqMap.put(currentChar, end);

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
    public static void main (String[] a) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
        System.out.println(lengthOfLongestSubstring("dvdf"));// 3
    }
}
