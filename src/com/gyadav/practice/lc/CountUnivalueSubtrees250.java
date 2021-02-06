package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class CountUnivalueSubtrees250 {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // Edge case
        if (root == null)
            return count;
        dfs(root);
        return count;
    }
    public boolean dfs (TreeNode node) {
        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }

        // Recursive case: Internal node
        boolean isUnival = true;
        if (node.left != null) {
            boolean leftCheck = dfs(node.left);
            if (!leftCheck || node.val != node.left.val)
                isUnival = false;
        }
        if (node.right != null) {
            boolean rightCheck = dfs(node.right);
            if (!rightCheck || node.val != node.right.val)
                isUnival = false;
        }
        if (isUnival)
            count++;
        return isUnival;
    }
}
