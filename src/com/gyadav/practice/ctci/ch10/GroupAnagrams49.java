package com.gyadav.practice.ctci.ch10;

import java.util.*;

public class GroupAnagrams49 {
    public static void main (String[] a) {
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        String[] strs = {"","b",""};
        System.out.println(groupAnagrams49.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Set<Integer> found = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (found.contains(i))
                continue;
            List<String> current = new ArrayList<>();
            current.add(strs[i]);
            for (int j = i + 1; j <strs.length; j++) {

                if (isAnagram(strs[i], strs[j])) {
                    current.add(strs[j]);
                    found.add(j);
                }
            }
            out.add(current);
        }
        return out;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : s1.toCharArray())
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        int matched = 0;
        for (int i =0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (charFreqMap.containsKey(ch)) {
                if (charFreqMap.get(ch) > 0) {
                    matched++;
                    charFreqMap.put(ch, charFreqMap.get(ch) - 1);
                } else {
                    break;
                }
            }
        }
        return matched == s2.length();
    }
}
