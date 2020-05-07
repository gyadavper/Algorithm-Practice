package com.gyadav.practice.lc;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> mergeInterval = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            mergeInterval.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergeInterval.add(newInterval);
        while (i < intervals.length) {
            mergeInterval.add(intervals[i]);
            i++;
        }
        return mergeInterval.toArray(new int[mergeInterval.size()][]);
    }
}
