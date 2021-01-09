package com.gyadav.practice.lcChallenge;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        if (s.length() % 2 == 0)
            return false;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : s.toCharArray())
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        int oddFound = 0;
        for (Map.Entry entry : charFreqMap.entrySet()) {
            if ((Integer)entry.getValue() % 2 != 0)
                oddFound++;
            if (oddFound > 1)
                return false;
        }
        return true;
    }
    public static void main (String[] a) {
        System.out.println(canPermutePalindrome("aab"));
    }
}
