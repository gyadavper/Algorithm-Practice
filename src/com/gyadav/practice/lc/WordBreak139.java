package com.gyadav.practice.lc;

import java.util.*;

public class WordBreak139 {
    public static void main (String[] a) {
        String s = "leet";
        WordBreak139 wordBreak139 = new WordBreak139();
        wordBreak139.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code")));
        System.out.println(s.substring(0,s.length()));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String str : wordDict)
            dict.add(str);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dict.contains(s.substring(i - j, i)) && dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
