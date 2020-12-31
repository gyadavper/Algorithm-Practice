package com.gyadav.practice.educative.allPatterns.mergeinterval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergeInterval = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergeInterval.add(intervals.get(i));
            i++;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        mergeInterval.add(newInterval);
        while(i < intervals.size()) {
            mergeInterval.add(intervals.get(i));
            i++;
        }
        return mergeInterval;
    }
}
