package com.gyadav.practice.educative.knapsack;

public class PartitionSet {
    public int canPartition(int[] num) {
        int sum = 0;
        for (int  i = 0; i < num.length; i++)
            sum += num[i];
        int n = num.length;
        boolean[][] dp = new boolean[n][sum/2 + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        for (int s = 1; s <= sum/2; s++)
            dp[0][s] = (num[0] == s ? true:false);
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum/2; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) {
                    dp[i][s] = dp[i-1][s - num[i]];
                }
            }
        }
        int sum1 = 0;
        for (int i = sum/2; i >=0; i--) {
            if (dp[n-1][i] == true) {
                sum1 = i;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }
}
