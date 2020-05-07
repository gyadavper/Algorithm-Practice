package com.gyadav.practice.educative.mergeinterval;

import java.util.Arrays;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start ));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
