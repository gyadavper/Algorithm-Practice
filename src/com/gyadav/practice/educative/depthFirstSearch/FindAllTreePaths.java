package com.gyadav.practice.educative.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecurcive(root, sum, currentPath, allPaths);
        return allPaths;
    }
    private static void findPathsRecurcive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;
        currentPath.add(root.val);
        if (root.val == sum && root.left == null && root.right == null)
            allPaths.add(new ArrayList<>(currentPath));
        else {
            findPathsRecurcive(root.left, sum - root.val, currentPath, allPaths);
            findPathsRecurcive(root.right, sum - root.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
