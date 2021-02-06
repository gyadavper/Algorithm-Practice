package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTInorderPostorderTraversal106 {
    Map<Integer, Integer> valueIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)
            valueIndexMap.put(inorder[i], i);

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP) {
        // Base case: Tree node
        if (startP > endP)
            return null;
        if (startP == endP)
            return new TreeNode(postorder[endP]);
        // Recursive case: Internal node
        TreeNode root = new TreeNode(postorder[endP]);
        int rootIndex = valueIndexMap.get(postorder[endP]);
        int numLeft = rootIndex - startI;
        int numRight = endI - rootIndex;
        root.left = buildTreeHelper(inorder, startI, rootIndex - 1, postorder, startP, startP + numLeft);
        root.right = buildTreeHelper(inorder, rootIndex + 1, endI, postorder, startP + numLeft + 1, endP - 1);
        return root;
    }
}
