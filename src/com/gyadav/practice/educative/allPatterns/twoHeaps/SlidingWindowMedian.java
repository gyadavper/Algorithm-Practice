package com.gyadav.practice.educative.allPatterns.twoHeaps;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

    public static void main(String[] args) {
/*        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();*/

        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 0, 5 }, 4);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);

            reAdJustHeap();
            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size())
                    result[i - k + 1] = maxHeap.peek()/2.0 + minHeap.peek()/2.0;
                else
                    result[i - k + 1] = maxHeap.peek();
                int numberToRemove = nums[i - k + 1];
                if (numberToRemove <= maxHeap.peek())
                    maxHeap.remove(numberToRemove);
                else
                    minHeap.remove(numberToRemove);
                reAdJustHeap();
            }
        }
        return result;
    }

    private void reAdJustHeap(){
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }
}
