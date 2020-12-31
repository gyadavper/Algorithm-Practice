package com.gyadav.practice.educative_rev1.knapsack;

public class StairJump {
    public static void main(String[] a) {
        StairJump stairJump = new StairJump();
        System.out.println(stairJump.calculateFee(4, new int[] {2,3,4,5}));
    }

    public int calculateFee (int n, int[] fee) {
        return calculateFeeRecursive(n, fee, 0);
    }

    public int calculateFeeRecursive(int n, int[] fee, int currentIndex) {
        if (currentIndex >= fee.length)
            return 0;

        int jump1 = fee[currentIndex] + calculateFeeRecursive(n - 1, fee, currentIndex + 1);
        int jump2 = fee[currentIndex] + calculateFeeRecursive(n - 2, fee, currentIndex + 2);
        int jump3 = fee[currentIndex] + calculateFeeRecursive(n - 3, fee, currentIndex + 3);
        return Math.min(Math.min(jump1, jump2), jump3);
    }
}
