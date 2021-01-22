package com.gyadav.practice.educative_rev3.twopointers;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int right = 0;
        for (int n : arr) {
            if (n >= 0)
                break;
            right++;
        }
        int left = right - 1;
        int current = 0;
        while (current < arr.length && left >= 0 && right <arr.length) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare <= rightSquare) {
                squares[current] = leftSquare;
                left--;
            } else {
                squares[current] = rightSquare;
                right++;
            }
            current++;
        }
        while (left >= 0) {
            squares[current++] = arr[left] * arr[left];
            left--;
        }
        while (right < arr.length) {
            squares[current++] = arr[right] * arr[right];
            right++;
        }
        return squares;
    }

    public static void main(String[] a) {
        SortedArraySquares.makeSquares(new int[] {-2, -1, 0, 2, 3});
    }
}
