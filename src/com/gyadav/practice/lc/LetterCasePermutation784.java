package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    List<String> output = new ArrayList<>();

    public static void main(String[] a) {
        LetterCasePermutation784 letterCasePermutation784 = new LetterCasePermutation784();
        letterCasePermutation784.letterCasePermutation("a1b2");
    }

    public List<String> letterCasePermutation(String S) {
        StringBuilder sb = new StringBuilder();
        letterCaseHelper(S, 0, sb);
        return output;
    }

    private void letterCaseHelper(String str, int index, StringBuilder slate) {
        if (index == str.length()){
            output.add(slate.toString());
            return;
        }
        char currentChar = str.charAt(index);
        if (Character.isDigit(str.charAt(index))) {
            slate.append(currentChar);
            letterCaseHelper(str, index+1, slate);
            slate.deleteCharAt(index);
        } else {
            letterCaseHelper(str, index+1, slate.append(Character.toUpperCase(currentChar)));
            slate.deleteCharAt(index);
            letterCaseHelper(str, index+1, slate.append(Character.toLowerCase(currentChar)));
            slate.deleteCharAt(index);
        }
    }
}
