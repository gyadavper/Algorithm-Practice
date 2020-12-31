package com.gyadav.practice.educative.allPatterns.slidingwindow;

import java.util.HashMap;

/*Permutation in a String (hard) #
        Given a string and a pattern, find out if the string contains any permutation of the pattern.

        Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

        abc
        acb
        bac
        bca
        cab
        cba
        If a string has ‘n’ distinct characters it will have n!n! permutations.

        Example 1:

        Input: String="oidbcaf", Pattern="abc"
        Output: true
        Explanation: The string contains "bca" which is a permutation of the given pattern.*/
public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(findPermutation("ccccbbbbaaaa", "abc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int found = 0;
        int startWindow = 0;
        for (int i = 0; i < pattern.length(); i++) {
            frequencyMap.put(pattern.charAt(i), frequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        for (int endWindow = 0; endWindow < str.length(); endWindow++) {
            char rightChar = str.charAt(endWindow);
            if (frequencyMap.containsKey(rightChar)) {
                frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
                if (frequencyMap.get(rightChar) == 0) {
                    found++;
                }
            }
            if (found == frequencyMap.size()) {
                return true;
            }
            if (endWindow >= pattern.length() - 1) {
                char leftChar = str.charAt(startWindow);
                startWindow++;
                if (frequencyMap.containsKey(leftChar)) {
                    if (frequencyMap.get(leftChar) == 0) {
                        found--;
                    }
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                }
            }
        }
        return false;
    }
}
