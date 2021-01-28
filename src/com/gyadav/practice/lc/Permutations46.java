package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> slate = new ArrayList<>();
        permutationsHelper(nums, 0, slate);
        return output;
    }
    private void permutationsHelper(int[] nums, int index, List<Integer> slate) {
        // Base case: leaf node work
        if (nums.length == index) {
            output.add(new ArrayList<>(slate));
            return;
        }
        // Recursion case: Internal node worker
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            slate.add(nums[index]);
            permutationsHelper(nums, index + 1, slate);
            slate.remove(slate.size() - 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
