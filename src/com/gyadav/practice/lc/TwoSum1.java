package com.gyadav.practice.lc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (valueIndexMap.containsKey(find) && valueIndexMap.get(find) != i)
                return new int[]{i, valueIndexMap.get(find)};
            valueIndexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
