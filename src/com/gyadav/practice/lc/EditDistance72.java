package com.gyadav.practice.lc;

public class EditDistance72 {
    public static void main(String[] a) {
        EditDistance72 editDistance72 = new EditDistance72();
        editDistance72.minDistance("horse","ros");
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // Base case
        dp[0][0] = 0;
        for (int row = 1;  row <= m; row++)
            dp[row][0] = dp[row - 1][0] + 1;
        for (int col = 1; col <= n; col++)
            dp[0][col] = dp[0][col - 1] + 1;
        // Recursive case
        for (int row  = 1;  row <= m; row++) {
            for (int col = 1; col <= n; col++){
                int del = dp[row-1][col] + 1;
                int ins = dp[row][col - 1] + 1;
                int mis = dp[row - 1][col - 1] + (word1.charAt(row - 1) == word2.charAt(col - 1) ? 0 : 1);
                dp[row][col] = Math.min(Math.min(del, ins), mis);
            }
        }
        return dp[m][n];
    }
}
