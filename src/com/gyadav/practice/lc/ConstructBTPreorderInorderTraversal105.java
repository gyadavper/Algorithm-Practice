package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTPreorderInorderTraversal105 {
    Map<Integer, Integer> valueIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            valueIndexMap.put(inorder[i], i);
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI) {
        // Base case: Leaf node
        if (startP > endP)
            return null;
        if (startP == endP)
            return new TreeNode(preorder[startP]);
        // Recursive case: Internal node
        TreeNode root = new TreeNode(preorder[startP]);
        int rootIndex = valueIndexMap.get(preorder[startP]);
        int numLeft = rootIndex - startI;
        int numRight = endI - rootIndex;
        root.left = buildTreeHelper(preorder, startP + 1, startP + numLeft, inorder, startI, rootIndex - 1);
        root.right = buildTreeHelper(preorder, startP + numLeft + 1, endP, inorder, rootIndex + 1, endI);
        return root;
    }
}
