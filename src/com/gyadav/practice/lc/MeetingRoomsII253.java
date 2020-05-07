package com.gyadav.practice.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public int minMeetingRooms(int[][] intervals) {
        int minRooms = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, new EndCompare());
        Arrays.sort(intervals, new StartCompare());
        for(int i = 0; i < intervals.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public class EndCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2? -1 : o1 == o2 ? 0 : 1;
        }
    }

    public class StartCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] < o2[0]? -1 : o1 == o2 ? 0 : 1;
        }
    }
}
