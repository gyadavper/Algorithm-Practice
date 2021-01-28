package com.gyadav.practice.interviewks.sorting;

public class InsertionSort {
    public static void insertionSortImperative(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
    }
    public static void main (String[] a) {
        int[] input = {6, 4, 3, 2, 5, 1};
        InsertionSort.insertionSortImperative(input);
    }
}
