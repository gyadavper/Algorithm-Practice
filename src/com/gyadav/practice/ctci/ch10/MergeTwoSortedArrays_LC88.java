package com.gyadav.practice.ctci.ch10;

public class MergeTwoSortedArrays_LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1LastIndex = nums1.length - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >=0) {
            if (nums1[m] > nums2[n]) {
                nums1[num1LastIndex] = nums1[m];
                m--;
            } else {
                nums1[num1LastIndex] = nums2[n];
                n--;
            }
            num1LastIndex--;
        }

        while (m>=0)
            nums1[num1LastIndex--] = nums1[m--];
        while (n>=0)
            nums1[num1LastIndex--] = nums2[n--];
    }
}
