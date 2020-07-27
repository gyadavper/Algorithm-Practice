package com.gyadav.practice.educative.topologicalSort;

import java.util.*;

public class MinimumHeightTrees {
    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (nodes <= 0)
            return minHeightTrees;
        if (nodes == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            inDegree.put(n1, inDegree. get(n1) + 1);
            inDegree.put(n2, inDegree.get(n2) + 1);
        }
        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 1)
                leaves.add(entry.getKey());
        }
        int totalNodes = nodes;
        while (totalNodes > 2) {
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1)
                        leaves.add(child);
                }
            }
        }
        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }
}
