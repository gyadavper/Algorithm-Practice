package com.gyadav.practice.educative.allPatterns.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LargestPairs {
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> (n1[0] + n1[1]) - (n2[0] + n2[1]));
        for (int i = 0; i < nums1.length && i < k;i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[] {nums1[i], nums2[j]});
                } else {
                    if (nums1[i] + nums2[j] < minHeap.peek()[0] + minHeap.peek()[1]) {
                        break;
                    } else {
                        minHeap.poll();
                        minHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        return new ArrayList<>(minHeap);
    }
}
