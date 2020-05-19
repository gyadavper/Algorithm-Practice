package com.gyadav.practice.educative.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size  = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++){
                TreeNode currentLevel = queue.poll();
                list.add(currentLevel.val);
                if (currentLevel.left != null)
                    queue.offer(currentLevel.left);
                if (currentLevel.right != null)
                    queue.offer(currentLevel.right);
            }
            result.add(0, list);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
