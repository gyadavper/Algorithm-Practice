package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class BalancedBinaryTree110 {
    boolean isBalance = true;

    public static void main(String[] a) {
        BalancedBinaryTree110 binaryTreeRightSide199 = new BalancedBinaryTree110();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        System.out.println(binaryTreeRightSide199.isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root) {
        // Edge case
        if (root == null)
            return isBalance;
        dfs(root);
        return isBalance;
    }

    public int dfs(TreeNode node) {
        // Base case: Leaf node
        if (node.left == null && node.right == null)
            return 0;
        // Recursive case: Internal node
        int left = 0, right = 0;
        if (node.left != null)
            left = dfs(node.left);
        if (node.right != null)
            right = dfs(node.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return Math.max(left, right) + 1;
    }
}
