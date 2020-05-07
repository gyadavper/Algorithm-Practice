package com.gyadav.practice.lc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Collections.sort(Arrays.asList(intervals), new compare());
        LinkedList<int[]> mergedList = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            } else {
                mergedList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        mergedList.add(new int[]{start, end});
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public class compare implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
        }
    }
}
