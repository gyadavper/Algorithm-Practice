package com.gyadav.practice.educative_rev1.knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

    public boolean canPartition (int[] num, int sum) {
        return canPartitionRecursive(num, sum, 0);
    }

    public boolean canPartitionRecursive (int[] num, int target, int index) {
        if (index >= num.length || target < 0)
            return false;
        if (target == 0)
            return true;
        if (num[index] <= target) {
            if (canPartitionRecursive(num, target - num[index], index + 1 ))
                return true;
        }
        return canPartitionRecursive(num, target, index + 1);
    }
}
