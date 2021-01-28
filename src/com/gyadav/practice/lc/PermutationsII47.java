package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII47 {
    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] a) {
        PermutationsII47 permutationsII47 = new PermutationsII47();
        permutationsII47.permuteUnique(new int[] {1,1,2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> slate = new ArrayList<>();
        permutationsIIHelper(nums, 0, slate);
        return output;
    }

    private void permutationsIIHelper(int[] nums, int index, List<Integer> slate) {
        // Base case: Leaf worker
        if (nums.length == index) {
            output.add(new ArrayList<>(slate));
            return;
        }
        // Recursion case: Internal node worker
        Set<Integer> uniqueSet = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (uniqueSet.contains(nums[i])) {
                continue;
            } else {
                uniqueSet.add(nums[i]);
                swap(nums, index, i);
                slate.add(nums[index]);
                permutationsIIHelper(nums, index + 1, slate);
                slate.remove(slate.size() - 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
