package com.gyadav.practice.educative.allPatterns.mergeinterval;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};
public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;
        int minRooms = 0;
        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));
        Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));
        for (int i = 0; i < meetings.size(); i++) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= meetings.get(i).start) {
                minHeap.poll();
            }
            minHeap.offer(meetings.get(i));
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

}
