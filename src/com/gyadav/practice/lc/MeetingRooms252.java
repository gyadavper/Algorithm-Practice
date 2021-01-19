package com.gyadav.practice.lc;

import java.util.Arrays;

public class MeetingRooms252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
            return true;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] <= intervals[j][0]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
