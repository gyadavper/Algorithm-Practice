package com.gyadav.practice.lc;

import java.util.*;

public class LetterCombinationsPhoneNumber17 {
    List<String> output = new ArrayList<>();

    public  static void main(String[] a) {
        LetterCombinationsPhoneNumber17 letterCombinationsPhoneNumber17 = new LetterCombinationsPhoneNumber17();
        letterCombinationsPhoneNumber17.letterCombinations("");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return output;
        Map<Character, List<Character>> numCharMap = new HashMap<>();
        numCharMap.put('2', Arrays.asList('a','b','c'));
        numCharMap.put('3', Arrays.asList('d','e','f'));
        numCharMap.put('4', Arrays.asList('g','h','i'));
        numCharMap.put('5', Arrays.asList('j','k','l'));
        numCharMap.put('6', Arrays.asList('m','n','o'));
        numCharMap.put('7', Arrays.asList('p','q','r','s'));
        numCharMap.put('8', Arrays.asList('t','u','v'));
        numCharMap.put('9', Arrays.asList('w','x','y','z'));
        StringBuilder slate = new StringBuilder();
        letterCombinationsHelper(digits, 0, slate, numCharMap);
        return output;
    }

    private void letterCombinationsHelper(String digits, int index, StringBuilder slate, Map <Character, List<Character>> numCharMap) {
        // Base Case: Leaf level worker
        if (index == digits.length()) {
            output.add(slate.toString());
            return;
        }
        // Recursion Case: Internal node worker
        char current = digits.charAt(index);
        for (char alphabet : numCharMap.get(current)) {
            slate.append(alphabet);
            letterCombinationsHelper(digits, index+1, slate, numCharMap);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}
