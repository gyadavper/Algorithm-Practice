package com.gyadav.practice.educative_rev3.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int startWindow = 0, wordLen = words[0].length(), matched = 0;
        Map<String, Integer> stringFreqMap = new HashMap<>();
        for (String s : words)
            stringFreqMap.put(s, stringFreqMap.getOrDefault(s, 0) + 1);
        for (int endWindow = 0; endWindow < str.length() - wordLen; endWindow ++) {
            String rightString = str.substring(endWindow, endWindow + wordLen);
            if (stringFreqMap.containsKey(rightString)) {
                stringFreqMap.put(rightString, stringFreqMap.get(rightString) - 1);
                if (stringFreqMap.get(rightString) >= 0)
                    matched++;
            }

            while (endWindow - startWindow + 1> wordLen*words.length) {
                String leftString = str.substring(startWindow, startWindow + wordLen);
                startWindow ++;
                if (stringFreqMap.containsKey(leftString)) {
                    if (stringFreqMap.get(leftString) >= 0)
                        matched--;
                    stringFreqMap.put(leftString, stringFreqMap.get(leftString) + 1);
                }
            }
            if (matched == words.length)
                resultIndices.add(startWindow);
        }
        return resultIndices;
    }
    public static void main (String[] a) {
        String[] Words = {"cat", "fox"};
        System.out.println(WordConcatenation.findWordConcatenation("catfoxcat", Words));
    }
}
