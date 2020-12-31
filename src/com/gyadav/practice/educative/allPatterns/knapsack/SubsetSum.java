package com.gyadav.practice.educative.allPatterns.knapsack;

public class SubsetSum {
    static int countSubsets (int[] num, int sum) {
        return totalSubsets (num, sum, 0, 0, 0);
    }
    static int totalSubsets(int[] num, int sum, int count, int currentIndex, int subSet) {
        if (subSet == sum)
            return 1;
        if (num.length == currentIndex)
            return 0;
        int s1 = totalSubsets(num, sum, count, currentIndex + 1, subSet + num[currentIndex]);
        int s2 = totalSubsets(num, sum, count, currentIndex + 1, subSet);
        return s1 + s2;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
