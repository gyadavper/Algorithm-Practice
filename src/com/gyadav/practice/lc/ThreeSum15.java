package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //Check for duplicates and skip
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            findTwoSum(nums, - nums[i], i + 1, output);
        }
        return output;
    }

    public void findTwoSum(int[] nums, int target, int start, List<List<Integer>> output) {
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                output.add(new ArrayList<>(Arrays.asList(-target, nums[start++], nums[end--])));
                //Skip Duplicates
                while (start < end && nums[start] == nums[start - 1])
                    start++;
                while (start < end && nums[end] == nums[end + 1])
                    end--;
            } else if (sum < target)
                start++;
            else
                end--;
        }
    }
}
