package com.gyadav.practice.educative.twopointer;

public class ShortestWindowSort {
    public static void main(String[] a){
        sort(new int[] {1, 2, 3});
    }
    public static int sort(int[] arr) {
        int startWindow = 0;
        int endWindow = arr.length - 1;
        while (startWindow < arr.length -1) {
            if(arr[startWindow] > arr[startWindow + 1]){
                break;
            } else {
                startWindow++;
            }
        }

        if(startWindow == arr.length - 1){
            return 0;
        }
        while (endWindow > 0) {
            if(arr[endWindow] < arr[endWindow - 1]){
                break;
            } else {
                endWindow--;
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( int i = startWindow; i <= endWindow; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        while (startWindow > 0) {
            if (arr[startWindow - 1] > min) {
                startWindow--;
            } else {
                break;
            }
        }
        while (endWindow < arr.length - 1) {
            if(arr[endWindow + 1] < max) {
                endWindow++;
            } else {
                break;
            }
        }
        return endWindow - startWindow + 1;
    }
}
