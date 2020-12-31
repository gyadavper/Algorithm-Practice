package com.gyadav.practice.educative.allPatterns.twoHeaps;

import java.util.PriorityQueue;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> capitalMinHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);
        for (int i = 0; i < n; i++)
            capitalMinHeap.add(i);
        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            while (!capitalMinHeap.isEmpty() && capital[capitalMinHeap.peek()] <= availableCapital) {
                profitMaxHeap.add(capitalMinHeap.poll());
            }
            if (profitMaxHeap.isEmpty())
                break;
            availableCapital = availableCapital + profits[profitMaxHeap.poll()];
        }
        return availableCapital;
    }
}
