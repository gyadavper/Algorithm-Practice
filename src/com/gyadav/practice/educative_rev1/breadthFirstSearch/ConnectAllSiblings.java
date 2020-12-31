package com.gyadav.practice.educative_rev1.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode previousNode = root;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != root) {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }
}
