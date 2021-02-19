package com.gyadav.practice.lc;

public class LongestCommonSubsequence1143 {
    public static void main(String[] a) {
        LongestCommonSubsequence1143 longestCommonSubsequence1143 = new LongestCommonSubsequence1143();
        longestCommonSubsequence1143.longestCommonSubsequence("abcde","ace");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp  = new int[m+1][n+1];
        for (int row = 1; row <= m; row++) {
            for (int col =1; col <=n; col++) {
                int ins = dp[row][col-1];
                int del = dp[row-1][col];
                int mis = dp[row-1][col-1] + text1.charAt(row-1) == text2.charAt(col-1)? 1: 0;
                dp[row][col] = Math.max(Math.max(ins, del), mis);
            }
        }
        return dp[m][n];
    }
}
