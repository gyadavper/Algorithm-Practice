package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                out.add(nums1[i]);
                i++;
                j++;
                while (i < nums1.length && nums1[i] == nums1[i - 1])
                    i++;
                while (j < nums2.length && nums2[j] == nums2[j - 1])
                    j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return listToArray(out);
    }

    public int[] listToArray(List<Integer> list) {
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}
