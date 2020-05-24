package com.gyadav.practice.educative.depthFirstSearch;

public class MaximumPathSum {
    private static int maxSum;
    public static int findMaximumPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findSum(root);
        return maxSum;
    }
    private static int findSum(TreeNode currentNode) {
        if (currentNode == null)
            return 0;
        int maxLeftSum = findSum(currentNode.left);
        int maxRightSum = findSum(currentNode.right);
        maxLeftSum = Math.max(maxLeftSum, 0);
        maxRightSum = Math.max(maxRightSum, 0);
        int sum = maxLeftSum + maxRightSum + currentNode.val;
        maxSum = Math.max(maxSum, sum);
        return Math.max(maxLeftSum, maxRightSum) + currentNode.val;
    }
}
