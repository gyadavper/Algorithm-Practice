package com.gyadav.practice.educative.mergeinterval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval {
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}

class EmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.interval.start, b.interval.start));

        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;

        while (!minHeap.isEmpty()) {
            EmployeeInterval queTop = minHeap.poll();
            if (previousInterval.end < queTop.interval.start) {
                result.add(new Interval(previousInterval.end, queTop.interval.start));
                previousInterval = queTop.interval;
            } else {
                if (previousInterval.end < queTop.interval.end) {
                    previousInterval = queTop.interval;
                }
            }
           List<Interval> employeeSchedule = schedule.get(queTop.employeeIndex);
            if (employeeSchedule.size() > queTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(schedule.get(queTop.employeeIndex).get(queTop.intervalIndex + 1), queTop.employeeIndex, queTop.intervalIndex + 1 ));
            }
        }
        return result;
    }
}
