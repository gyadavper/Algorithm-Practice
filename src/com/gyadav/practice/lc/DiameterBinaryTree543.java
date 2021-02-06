package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class DiameterBinaryTree543 {
    int globalDia = 0;

    public static void main(String[] a) {
        DiameterBinaryTree543 binaryTreeRightSide199 = new DiameterBinaryTree543();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(binaryTreeRightSide199.diameterOfBinaryTree(treeNode));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Edge case
        if (root == null)
            return globalDia;
        dfs(root);
        return globalDia;
    }

    public int dfs (TreeNode node) {
        // Base case: Leaf node
        if (node.left != null && node.right != null)
            return 0;
        // Recursive case: Internal node
        int left = 0, right = 0, localDia = 0;
        if (node.left != null) {
            left = dfs(node.left);
            localDia = left + 1;
        }
        if (node.right != null) {
            right = dfs(node.right);
            localDia += right + 1;
        }
        globalDia = Math.max(globalDia, localDia);
        return Math.max(left, right) + 1;
    }
}
