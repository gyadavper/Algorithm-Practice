package com.gyadav.practice.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordConcatenation {
    public static void main(String[] args ){
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if(words.length == 0)
            return resultIndices;
        int wordsLength = words[0].length();
        int wordsSize = words.length;
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String s : words) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i <= str.length() - wordsLength * wordsSize; i++) {
            HashMap<String, Integer> wordsSeen = new HashMap<>();
            for(int j = 0; j < wordsSize; j++){
                int nextIndex = i + j*wordsLength;
                String word = str.substring(nextIndex, nextIndex + wordsLength);

                if(!frequencyMap.containsKey(word))
                    break;
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);
                if(wordsSeen.get(word) > frequencyMap.getOrDefault(word, 0))
                    break;
                if(j + 1 == wordsSize) {
                    resultIndices.add(i);
                }

            }
        }
        return resultIndices;
    }
}
