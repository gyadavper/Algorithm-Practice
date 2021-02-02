package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] a) {
        CombinationSumII40 combinationSumII40 = new CombinationSumII40();
        combinationSumII40.combinationSum2(new int[]{2,5,2,1,2}, 5);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> slate = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, 0, slate, 0, target);
        return output;
    }

    private void combinationSum2Helper(int[] candidates, int index, List<Integer> slate, int sum, int target) {
        // Backtracking case
        if (sum == target) {
            output.add(new ArrayList<>(slate));
            return;
        }
            if (sum > target)
                return;
        // Base case: Leaf node worker
        if (index == candidates.length)
            return;
        // Recursive case: Internal node worker
        int count = 0;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] != candidates[i])
                break;
            count++;
        }
        // Exclude
        combinationSum2Helper(candidates, index+count, slate, sum, target);
        // Multi Include
        for (int i = 1; i <= count; i++) {
            slate.add(candidates[index]);
            sum += candidates[index];
            combinationSum2Helper(candidates, index + count, slate, sum , target);
        }
        for (int i = 1; i <= count; i++) {
            sum -= candidates[index];
            slate.remove(slate.size() - 1);
        }
    }
}
