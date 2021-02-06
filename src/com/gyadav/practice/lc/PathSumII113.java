package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Edge case
        if (root == null)
            return output;
        List<Integer> slate = new ArrayList<>();
        dfs(root, targetSum, slate);
        return output;
    }
    public void dfs(TreeNode node, int sum, List<Integer> slate) {
        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                slate.add(node.val);
                output.add(new ArrayList<>(slate));
                slate.remove(slate.size() - 1);
            }
            return;
        }
        // Recursive case: Internal node worker
        slate.add(node.val);
        if (node.left != null)
            dfs(node.left,node.val - sum, slate);
        if (node.right != null)
            dfs(node.right, node.val - sum, slate);
        slate.remove(slate.size() - 1);
    }
}
