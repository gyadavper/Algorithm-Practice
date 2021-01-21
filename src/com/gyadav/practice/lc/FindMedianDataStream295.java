package com.gyadav.practice.lc;

import java.util.PriorityQueue;

public class FindMedianDataStream295 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public FindMedianDataStream295() {
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() > num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}
