package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class KthSmallestElementBST230 {
    int KthSmallest = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        int numPred = 0;
        dfs (root, numPred, k);
        return KthSmallest;
    }
    private int dfs (TreeNode node, int numPred, int k) {
        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            numPred++;
            if (numPred == k)
                KthSmallest = node.val;
            return numPred;
        }
        // Recursive case: Internal node
        if (node.left != null)
            numPred = dfs(node.left, numPred, k);
        numPred++;
        if (numPred == k)
            KthSmallest = node.val;
        if (node.right != null)
            numPred = dfs(node.right, numPred, k);
        return numPred;
    }
}
