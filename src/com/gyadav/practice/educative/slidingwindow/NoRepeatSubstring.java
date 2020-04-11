package com.gyadav.practice.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*Given a string, find the length of the longest substring which has no repeating characters.

        Example 1:

        Input: String="aabccbb"
        Output: 3
        Explanation: The longest substring without any repeating characters is "abc".*/
public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findLength("abba"));
    }

    public static int findLength(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int startPointer = 0;
        for (int endPointer = 0; endPointer < str.length(); endPointer++) {
            if (map.containsKey(str.charAt(endPointer))) {
                int del_index = map.get(str.charAt(endPointer));
                startPointer = Math.max(startPointer, (del_index + 1));
            }
                map.put(str.charAt(endPointer), endPointer);
                max = Math.max(max, (endPointer - startPointer) + 1);
            }
        return max;
    }
}
