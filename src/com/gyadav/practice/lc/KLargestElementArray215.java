package com.gyadav.practice.lc;

public class KLargestElementArray215 {
    public static void main (String[] a) {
        KLargestElementArray215 kLargestElementArray215 = new KLargestElementArray215();
        System.out.println(kLargestElementArray215.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, nums.length - k, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSelect(int[] nums, int index, int start, int end) {
        if (start == end)
            return;
        //Lomoto's Partition
        int pivot = (int) (Math.random() * (end - start) + start);
        swap(nums, start, pivot);
        int smaller = start;
        for (int bigger = start + 1; bigger<=end; bigger++) {
            if (nums[bigger] < nums[start]) {
                smaller++;
                swap(nums, smaller, bigger);
            }
        }
        swap(nums, smaller, start);
        if (smaller == index)
            return;
        if (smaller < index)
             quickSelect(nums, index, smaller + 1, end);
        else
             quickSelect(nums, index, start, smaller - 1);
    }

    public void swap (int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
