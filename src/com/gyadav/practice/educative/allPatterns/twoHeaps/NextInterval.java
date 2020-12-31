package com.gyadav.practice.educative.allPatterns.twoHeaps;

import java.util.PriorityQueue;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int length = intervals.length;
        int[] result = new int[length];

        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(length, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(length, (i1, i2) -> intervals[i2].start - intervals[i1].start);
        for (int i = 0; i < length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        for (int i = 0; i < length; i++) {
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                int topStart = maxStartHeap.poll();
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
