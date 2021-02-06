package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null)
            return output;
        Stack<NodeState> stack = new Stack<>();
        stack.push(new NodeState(root, "none"));
        while (!stack.isEmpty()) {
            NodeState current = stack.peek();
            if (current.state.equals("none")) {
                current.state = "arrival";
                output.add(current.node.val);
                if (current.node.left != null)
                    stack.push(new NodeState(current.node.left, "none"));
            }
            else if(current.state.equals("arrival")) {
                current.state = "interim";
                if (current.node.right != null)
                    stack.push((new NodeState(current.node.right, "none")));
            }
            else if (current.state.equals("interim")) {
                current.state = "departure";
                stack.pop();
            }
        }
        return output;
    }

    class NodeState {
        TreeNode node;
        String state;

        public NodeState(TreeNode node, String state) {
            this.node = node;
            this.state = state;
        }
    }
}
