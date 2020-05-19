package com.gyadav.practice.educative.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (treeNodes.size() > 0) {
            int size = treeNodes.size();
            List<Integer> integerList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.poll();
                integerList.add(treeNode.val);
                if (treeNode.left != null)
                    treeNodes.offer(treeNode.left);
                if (treeNode.right != null)
                    treeNodes.offer(treeNode.right);
            }
            result.add(integerList);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
