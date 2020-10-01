package com.gyadav.practice.educative_rev1.slidingwindow;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int startWindow = 0, maxOne = 0, maxLength = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            if (arr[endWindow] == 1)
                maxOne++;
            if (endWindow -startWindow + 1 - maxOne > k) {
                if (arr[startWindow] == 1)
                    maxOne--;
                startWindow++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }
        return maxLength;
    }
}
