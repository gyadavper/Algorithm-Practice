package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

import java.util.*;

public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null)
            return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                temp.add(current.val);
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            if (isReverse) {
                Collections.reverse(temp);
                output.add(temp);
                isReverse = false;
            } else {
                output.add(temp);
                isReverse = true;
            }
        }
        return output;
    }
}
