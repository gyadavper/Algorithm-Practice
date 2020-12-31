package com.gyadav.practice.educative.allPatterns.knapsack;

public class TargetSum {
    public int findTargetSubsets(int[] num, int s) {
        return findTargetSubsetsRecursive(num, s, 0);
    }
    public int findTargetSubsetsRecursive(int[] num, int s, int currentIndex) {
        if (s == 0)
            return 1;
        if (num.length == 0 || currentIndex >= num.length)
            return 0;
        int s1 = findTargetSubsetsRecursive(num, s - num[currentIndex], currentIndex + 1);
        int s2 = findTargetSubsetsRecursive(num, s + num[currentIndex], currentIndex + 1);
        return s1 + s2;
    }
}
