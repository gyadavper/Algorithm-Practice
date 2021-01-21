package com.gyadav.practice.lc;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements347 {
    public static void main(String[] a) {
        TopKFrequentElements347 topKFrequentElements347 = new TopKFrequentElements347();
        topKFrequentElements347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int n : nums)
            numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);

        int [] unique = new int[numFreqMap.size()];
        int index = unique.length - k;
        int i = 0;
        for (int key: numFreqMap.keySet())
            unique[i++] = key;
        // Do quick select on unique
        quickSelect(unique, index, 0, unique.length - 1, numFreqMap);

        int[] output = new int[k];
        int j = 0;
        for (int m = index; m < unique.length; m++)
            output[j++] = unique[m];
        return output;
    }

    public void quickSelect(int[] nums, int index, int start, int end, Map<Integer, Integer> numFreqMap) {
        if (start == end)
            return;
        int pivot = (int) (Math.random() * (end - start) + start);
        int smaller = start;
        swap(nums, start, pivot);
        for (int bigger = start + 1; bigger <= end; bigger++) {
            if (numFreqMap.get(nums[bigger]) < numFreqMap.get(nums[start])) {
                smaller++;
                swap(nums, smaller, bigger);
            }
        }
        swap(nums, start, smaller);
        if (smaller == index)
            return;
        if (smaller < index)
            quickSelect(nums, index, smaller + 1, end, numFreqMap);
        else
            quickSelect(nums, index, start, smaller - 1, numFreqMap);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
