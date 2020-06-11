package com.gyadav.practice.educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {
    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int size = permutations.size();
                for (int j = 0; j < size; j++) {
                    char[] charArray = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(charArray[i]))
                        charArray[i] = Character.toLowerCase(charArray[i]);
                    else
                        charArray[i] = Character.toUpperCase(charArray[i]);
                    permutations.add(String.valueOf(charArray));
                }
            }
        }
        return permutations;
    }
}
