package com.gyadav.practice.educative.allPatterns.mergeinterval;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxLoad = 0;
        int currentLoad = 0;
        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));
        Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));
        for (Job job : jobs) {

            while (!minHeap.isEmpty() && minHeap.peek().end >= job.start) {
                currentLoad -= minHeap.peek().cpuLoad;
                minHeap.poll();
            }
            minHeap.offer(job);
            currentLoad += job.cpuLoad;
            maxLoad = Math.max(maxLoad, currentLoad);
        }
        return maxLoad;
    }
}