package com.gyadav.practice.educative.allPatterns.mergeinterval;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
    public static List<Interval> merge (List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergeInterval = new LinkedList<>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                mergeInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergeInterval.add(new Interval(start, end));
        return mergeInterval;
    }
}
