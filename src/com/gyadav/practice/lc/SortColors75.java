package com.gyadav.practice.lc;

public class SortColors75 {
    public static void main(String[] a) {
        SortColors75 sortColors75 = new SortColors75();
        sortColors75.sortColors(new int[] {1,2,0});
    }

    public void sortColors(int[] nums) {
        int smaller = 0;
        int bigger = nums.length - 1;
        int i = 0;
        while (i <= bigger) {
            if (nums[i] == 0) {
                swap(nums, smaller, i);
                i++;
                smaller++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, bigger,i);
                bigger--;
            }

        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
