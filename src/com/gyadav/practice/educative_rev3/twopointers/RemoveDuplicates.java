package com.gyadav.practice.educative_rev3.twopointers;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}
