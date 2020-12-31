package com.gyadav.practice.educative.allPatterns.depthFirstSearch;

public class TreeDiameter {
    private static int treeDiameter = 0;
    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }
    private static int calculateHeight(TreeNode currentNode) {
        if (currentNode == null)
            return 0;
        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);
        int diameter = leftTreeHeight + rightTreeHeight + 1;
        treeDiameter = Math.max(treeDiameter, diameter);
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
