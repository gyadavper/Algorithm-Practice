package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII90 {
    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] a) {
        SubsetsII90 subsetsII90 = new SubsetsII90();
        subsetsII90.subsetsWithDup(new int[]{1,2,2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> slate = new LinkedList<>();
        subsetsWithDupHelper (nums, 0, slate);
        return output;
    }

    private void subsetsWithDupHelper (int[] nums, int index, List<Integer> slate) {
        // Base case: Leaf level worker
        if (index >= nums.length) {
            output.add(new ArrayList<>(slate));
            return;
        }

        // Recursive case: Internal node worker
        // Count duplicates
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[index] != nums[i])
                break;
            count++;
        }
        // Exclude
        subsetsWithDupHelper(nums, index + count, slate);
        // Multi Include
        for (int i = 1; i <= count; i++) {
            slate.add(nums[index]);
            subsetsWithDupHelper(nums, index + count, slate);
        }
        for (int i = 1; i <=count; i++)
            slate.remove(slate.size() - 1);
    }
}
