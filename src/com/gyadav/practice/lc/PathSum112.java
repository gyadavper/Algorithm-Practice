package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class PathSum112 {
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Edge case
        if (root == null)
            return false;
        dfs(root, targetSum);
        return hasPath;
    }
    public void dfs(TreeNode node, int sum) {
        // Base cae: Leaf node
        if (node.left == null && node.right == null) {
            if (node.val == sum)
                hasPath = true;
        }
        // Recursive case: Internal node
        if (node.left != null)
            dfs(node.left, sum - node.val);
        if (node.right != null)
            dfs(node.right, sum - node.val);
    }
}
