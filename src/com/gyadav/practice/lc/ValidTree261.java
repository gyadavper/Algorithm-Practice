package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTree261 {
    public static void main(String[] a) {
        ValidTree261 validTree261 = new ValidTree261();
        validTree261.validTree(3, new int[][]{{0,1}, {0,2},{1,2}});
    }

    public boolean validTree(int n, int[][] edges) {
        // Build graph using adjList
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        // Parent array to keep track of back-edge or cross edge
        int[]  parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = -1;
        int connected = 0;
        // Perform BFS or DFS
        // Outer Loop
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                connected++;
                if (connected > 1)
                    return false;
                parent[i] = i;
                if (isCyclic_dfs (i, adjList, parent))
                    return false;
            }
        }
        return true;
    }

    private boolean isCyclic_bfs(int node, List<Integer>[] adjList, int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int child: adjList[current]) {
                if (parent[child] == -1 && parent[current] != child) {
                    parent[child] = current;
                    queue.offer(child);
                } else if (parent[current] != child)
                    return true;
            }
        }
        return false;
    }

    private boolean isCyclic_dfs (int node, List<Integer>[] adjList, int[] parent) {
        for (int neighbour : adjList[node]) {
            if (parent[neighbour] == -1 && parent[node] != neighbour) {
                parent[neighbour] = node;
                if (isCyclic_dfs(neighbour, adjList, parent))
                    return false;
            } else if(parent[node] != neighbour)
                return true;
        }
        return false;
    }
}
