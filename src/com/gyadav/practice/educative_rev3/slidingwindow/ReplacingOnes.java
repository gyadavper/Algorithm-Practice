package com.gyadav.practice.educative_rev3.slidingwindow;

public class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int startWindow = 0, windowLength = 0, zeroSoFar = 0;
        for (int endWindow = 0; endWindow < arr.length; endWindow++) {
            if (arr[endWindow] == 0)
                zeroSoFar++;
            if (zeroSoFar > k) { //use if instead of while, contraction is not required you already have max len
                if (arr[startWindow] == 0)
                    zeroSoFar--;
                startWindow++;
            }
            windowLength = Math.max(windowLength, endWindow - startWindow + 1);
        }
        return windowLength;
    }
}
