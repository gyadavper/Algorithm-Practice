package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

public class ConvertSortedArrayBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstHelper(nums, 0, nums.length - 1);
    }
    private TreeNode bstHelper(int[] arr, int start, int end) {
        // Base case: Leaf node
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(arr[start]);
        // Recursive case: Internal node
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = bstHelper(arr, start, mid - 1);
        root.right = bstHelper(arr, mid + 1, end);
        return root;
    }
}
