package com.gyadav.practice.educative.allPatterns.fastandslowpointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean find(int num) {
        Set<Integer> uniqueSet = new HashSet<>();
        while (num != 1) {
            num = digitSum(num);
            if (uniqueSet.contains(num)) {
                return false;
            }
            uniqueSet.add(num);
        }
        return true;
    }
    public static int digitSum (int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit);
            num = num / 10;
        }
        return sum;
    }
}
