package com.gyadav.practice.educative.allPatterns.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minLength = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
                if (currentNode.right == null && currentNode.left == null)
                    return minLength;
            }
            minLength++;

        }
        return minLength;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
/*        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));*/
    }
}
