package com.gyadav.practice.educative.slidingwindow;

import java.util.Collections;
import java.util.HashMap;

class LongestSubstringKDistinct {
    public static void main (String[] args) {
        System.out.println(findLength("LOVELEETCODE", 4));
    }
    public static int findLength(String str, int k) {
        if(str.length()*k == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        int startPointer = 0;

        for (int endPointer = 0; endPointer < str.length(); endPointer++){
            map.put(str.charAt(endPointer), endPointer);

            if(map.size() > k) {
                int del_indx = Collections.min(map.values());

                map.remove(str.charAt(del_indx));
                startPointer = del_indx + 1;
            }
            maxLength = Math.max(maxLength, (endPointer - startPointer) + 1);
        }
        return maxLength;

/*        int n = s.length();
        if (n*k == 0) return 0;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 1;

        while (right < n) {
            // add new character and move right pointer
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;*/
    }
}
