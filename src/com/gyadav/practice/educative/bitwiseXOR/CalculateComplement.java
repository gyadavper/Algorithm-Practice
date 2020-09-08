package com.gyadav.practice.educative.bitwiseXOR;

public class CalculateComplement {
    public static int bitwiseComplement(int n) {
        int bitCount = 0;
        int num = n;
        while (num > 0) {
            bitCount++;
            num = num >> 1;
        }
        int all_bit_set = (int) Math.pow(2, bitCount) - 1;
        return n ^ all_bit_set;
    }
}
