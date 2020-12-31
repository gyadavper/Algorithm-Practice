package com.gyadav.practice.educative_rev1.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        for (char ch : str.toCharArray()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (Character.isAlphabetic(ch)) {
                    queue.add(s + Character.toUpperCase(ch));
                    queue.add(s + Character.toLowerCase(ch));
                } else {
                    queue.add(s + ch);
                }
            }

        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
