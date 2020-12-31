package com.gyadav.practice.educative.allPatterns.depthFirstSearch;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return (hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val));
    }
}
