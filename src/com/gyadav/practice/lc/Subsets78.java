package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets78 {
    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] a) {
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets(new int[] {1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> slate = new LinkedList<>();
        subsetsHelper(nums, 0, slate);
        return output;
    }

    private void subsetsHelper(int[] nums, int index, List<Integer> slate) {
        //Base case or leaf node work
        if (nums.length == index) {
            output.add(new ArrayList<>(slate));
            return;
        }
        //Recursion case or Internal node worker
        subsetsHelper(nums, index + 1, slate);
        slate.add(nums[index]);
        subsetsHelper(nums, index + 1, slate);
        slate.remove(slate.size() - 1);
    }
}
