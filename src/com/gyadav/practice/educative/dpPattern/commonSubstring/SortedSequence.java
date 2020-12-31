package com.gyadav.practice.educative.dpPattern.commonSubstring;

public class SortedSequence {
    public static void main(String[] a) {
        SortedSequence sortedSequence = new SortedSequence();
        System.out.println(sortedSequence.minDelete(new int[] {4,2,3,6,10,1,12}));
        System.out.println(sortedSequence.minDelete(new int[] {-4,10,3,7,15}));
        System.out.println(sortedSequence.minDelete(new int[] {3,2,1,0}));
    }

    public int minDelete(int[] arr) {
        return minDeleteRecursive(arr, 0, -1);
    }

    public int minDeleteRecursive(int[] arr, int currentIndex, int previousIndex) {
        if (currentIndex == arr.length)
            return 0;
        int c1 = arr.length - 1;
        if (previousIndex == -1 || arr[previousIndex] < arr[currentIndex])
            c1 = minDeleteRecursive(arr, currentIndex + 1, currentIndex);
        int c2 = 1 + minDeleteRecursive(arr, currentIndex + 1, currentIndex);
        return Math.min(c1, c2);
    }
}
