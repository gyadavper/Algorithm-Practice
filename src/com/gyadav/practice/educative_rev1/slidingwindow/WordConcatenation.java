package com.gyadav.practice.educative_rev1.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        int windowStart = 0, matched = 0;
        Map<String, Integer> stringFreqMap = new HashMap<>();
        for (String s: words)
            stringFreqMap.put(s, stringFreqMap.getOrDefault(s, 0) + 1);
        int wordLen = words[0].length();
        int subStart = 0;
        for (int endWindow = wordLen; endWindow <= str.length(); endWindow+=wordLen) {
            String rightString = str.substring(subStart, endWindow);
            if (stringFreqMap.containsKey(rightString)) {
                stringFreqMap.put(rightString, stringFreqMap.get(rightString) - 1);
                if (stringFreqMap.get(rightString) == 0)
                    matched++;
            }
                if (matched == stringFreqMap.size())
                    resultIndices.add(windowStart);
                if (endWindow >= wordLen * words.length) {
                    String leftString = str.substring(windowStart, windowStart + wordLen);
                    windowStart +=wordLen;
                    if (stringFreqMap.containsKey(leftString)) {
                        if (stringFreqMap.get(leftString) == 0)
                            matched--;
                        stringFreqMap.put(leftString, stringFreqMap.get(leftString) + 1);
                    }
                }
            subStart +=wordLen;
        }
        return resultIndices;
    }
    public static void main(String[] args) {
/*        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);*/
        List<Integer> result = WordConcatenation.findWordConcatenation("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] { "fooo","barr","wing","ding","wing" });
        System.out.println(result);
    }
}
