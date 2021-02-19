package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponentsUndirectedGraph323 {
    public int countComponents(int n, int[][] edges) {
        // Build graph
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        // Add edges to parent and child
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]); // Adding child to parent
            adjList[edges[i][1]].add(edges[i][0]); // Adding parent to child
        }
        // Keep track of visited components
        boolean[] visited =new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if ((!visited[i])) {
                components++;
                dfs(i, adjList, visited);
            }
        }
        return components;
    }
    private void bfs(int node, List<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);
        while (!queue.isEmpty()) {

                int current = queue.poll();
                for (int child : adjList[current]) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.offer(child);
                    }
                }
        }
    }
    private void dfs (int node, List<Integer>[] adjList, boolean[] visited) {
        visited[node] = true;
        for (int child: adjList[node]) {
            if (!visited[child]) {
                visited[child] = true;
                dfs(child, adjList, visited);
            }
        }
    }
}
