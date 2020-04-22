package com.gyadav.practice.educative.twopointer;

public class RemoveElement {
    public static int remove(int[] arr, int key) {
        int nonKey = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nonKey] = arr[i];
                nonKey++;
            }
        }
        return nonKey;
    }
}
