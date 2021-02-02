package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations77 {
    List<List<Integer>> output = new ArrayList<>();

    public static void main (String[] a) {
        Combinations77 combinations77 = new Combinations77();
        combinations77.combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> slate = new LinkedList<>();
/*        int[] nums = new int[n];
        for (int i = 1; i<=n; i++)
            nums[i-1] = i;*/

        combineHelper(n, 1, slate, k);
        return output;
    }

    private void combineHelper(int n, int index, List<Integer> slate, int k) {
        // Backtracking case
        if (slate.size() == k) {
            output.add(new ArrayList<>(slate));
            return;
        }
        // Base Case: Leaf worker
        if (index == n)
            return;
        // Recursive case: Internal node worker
        // Exclude
        combineHelper(n, index + 1, slate, k);
        // Include
        slate.add(index);
        combineHelper(n, index + 1, slate, k);
        slate.remove(slate.size() - 1);
    }
}
