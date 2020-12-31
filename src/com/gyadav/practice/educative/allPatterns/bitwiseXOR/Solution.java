package com.gyadav.practice.educative.allPatterns.bitwiseXOR;

public class Solution {
    public static int[][] flipAndInvertImage(int[][] arr) {
        int C = arr[0].length;
        for (int[] row : arr) {
            for (int i = 0; i < (C + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return arr;
    }
}
