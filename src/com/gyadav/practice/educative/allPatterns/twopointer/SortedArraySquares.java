package com.gyadav.practice.educative.allPatterns.twopointer;

public class SortedArraySquares {
    public static void main(String[] args){
        System.out.println(makeSquares(new int[] {-3, -1, 0, 1, 2}));
    }
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int secondPointer = 0;
        for (secondPointer = 0; secondPointer < arr.length; secondPointer++) {
            if (arr[secondPointer] >= 0) {
                break;
            }
        }
        int i = 0;
        int firstPointer = secondPointer - 1;
        while (firstPointer >= 0 && secondPointer < arr.length){
            int firstSq = arr[firstPointer] * arr[firstPointer];
            int secSq = arr[secondPointer] * arr[secondPointer];
            if (firstSq < secSq){
                squares[i] = firstSq;
                firstPointer--;
            } else
            {
                squares[i] = secSq;
                secondPointer++;
            }
            i++;
        }
        while (secondPointer < arr.length){
            int sq = arr[secondPointer] * arr[secondPointer];
            squares[i] = sq;
            i++;
            secondPointer++;
        }
        while (firstPointer >= 0){
            int sq = arr[firstPointer] * arr[firstPointer];
            squares[i] = sq;
            i++;
            firstPointer--;
        }
        return squares;
    }
}
