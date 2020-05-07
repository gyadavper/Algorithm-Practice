package com.gyadav.practice.lc;

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> mergeInterval = new LinkedList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {

            if (A[i][0] <= B[j][0] && A[i][1] >= B[j][0] || A[i][0] >= B[j][0] && A[i][0] <= B[j][1]) {
                mergeInterval.add(new int[] {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return mergeInterval.toArray(new int[mergeInterval.size()][]);
    }
}
