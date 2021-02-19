package com.gyadav.practice.lc;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite785 {
    public static void main(String[] a){
        IsGraphBipartite785 isGraphBipartite785 = new IsGraphBipartite785();
        System.out.println(isGraphBipartite785.isBipartite(new int[][]{{1,2,3}, {0,2},{0,1,3},{0,2}}));
    }

    public boolean isBipartite(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] distance = new int[graph.length];
        boolean[] color = new boolean[graph.length];
        // Outer loop
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;
        for (int i = 0; i < graph.length; i++) {
            if (parent[i] == -1) {
/*                if (!isBipartite_bfs(i, graph, parent, distance))
                    return false;*/
            }
            if (parent[i] == -1) {
                parent[i] = i;
                if (!isBipartite_dfs(i, graph, parent, color))
                    return false;
            }
        }
        return true;
    }

    private boolean isBipartite_bfs(int source, int[][] adjMatrix, int[] parent, int[] distance) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(source);
        distance[source] = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : adjMatrix[current]) {
                if (parent[neighbour] == -1 && parent[current] != neighbour) {
                    parent[neighbour] = current;
                    distance[neighbour] = distance[current] + 1;
                } else if (parent[current] != neighbour) {
                    if (distance[neighbour] == distance[current])
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite_dfs(int node, int[][] adjMatrix, int[] parent, boolean[] color) {
        for (int neighbour : adjMatrix[node]) {
            if (parent[neighbour] == -1 && parent[node] != neighbour) {
                parent[neighbour] = node;
                color[neighbour] = !color[node];
                if (!isBipartite_dfs(neighbour, adjMatrix, parent, color))
                    return false;
            } else if (parent[node] != neighbour) {
                if (color[neighbour] == color[node])
                    return false;
            }
        }
        return true;
    }
}
