package com.gyadav.practice.lc;


public class ConvertBSTSortedDoublyLinkedList426 {
        public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node sentinel = new Node();
        Node tail = dfs (root, sentinel);
        Node head = sentinel.right;
        tail.right = head;
        head.left = tail;
        return head;
    };

    private Node dfs(Node node, Node prev) {
        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            node.left = prev;
            prev.right = node;
            prev = node;
            return prev;
        }
        // Recursive case: Internal node
        if (node.left != null)
            prev = dfs(node.left, prev);
        node.left = prev;
        prev.right = node;
        prev = node;
        if (node.right != null)
            prev = dfs(node.right, prev);
        return prev;
    }

class Node {
        public int val;
        Node left;
        Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
