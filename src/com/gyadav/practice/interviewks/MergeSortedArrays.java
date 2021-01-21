package com.gyadav.practice.interviewks;

public class MergeSortedArrays {
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        // Find arr 2 end index
        int arr2End = 0;
        for (int n : arr2){
            if(n == 0)
                break;
            arr2End++;
        }
        arr2End--;
        int arr1End = arr1.length - 1;
        int current = arr2.length - 1;
        while (arr1End >= 1 && arr2End >= 1) {
            if (arr1[arr1End] <= arr2[arr2End]) {
                arr2[current] = arr2[arr2End];
                arr2End--;
            } else {
                arr2[current] = arr1[arr1End];
                arr1End--;
            }
            current--;
        }

        while(arr1End >= 1) {
            arr2[current--] = arr1[arr1End--];
        }
        while(arr2End >= 1) {
            arr2[current--] = arr2[arr2End--];
        }

    }
    public static void main(String[] a) {
        int [] arr1 = new int[]{1,2};
        int [] arr2 = new int[]{2,1,0};
        MergeSortedArrays.merger_first_into_second(arr1, arr2);
        System.out.println();
    }
}
