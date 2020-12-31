package com.gyadav.practice.educative.dpPattern.commonSubstring;

public class MSI {
    public static void main(String[] a) {
        MSI msi = new MSI();
        //System.out.println(msi.maxSequence(new int[] {4,1,2,6,10,1,12}));
        System.out.println(msi.maxSequence(new int[] {-4,10,3,7,15}));
    }

    public int maxSequence(int[] arr) {
        return maxSequenceRecursive(arr, 0, -1);
    }

    public int maxSequenceRecursive(int[] arr, int currentIndex, int previousIndex) {
        if (currentIndex >= arr.length)
            return 0;
        int sum1 = 0;
        if (previousIndex == -1 || arr[previousIndex] <= arr[currentIndex]) {
            sum1 = arr[currentIndex] + maxSequenceRecursive(arr, currentIndex + 1, currentIndex);
        }
        int sum2 = maxSequenceRecursive(arr, currentIndex + 1, previousIndex);
        return Math.max(sum1, sum2);
    }
}
