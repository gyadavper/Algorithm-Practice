package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.youtube.com/watch?v=RYaakWv5m6o&feature=emb_logo
// https://leetcode.com/problems/critical-connections-in-a-network/discuss/1059067/Java-Solution-With-Detailed-Explanation-and-Comments
public class CriticalConnectionsNetwork1192 {
    List<List<Integer>> criticalConn = new ArrayList<>();
    private int timeStamp = 0; // current time of discovery

    public static void main (String[] a) {
        CriticalConnectionsNetwork1192 criticalConnectionsNetwork1192 = new CriticalConnectionsNetwork1192();
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(0,1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(2,0));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(1,3));
        output.add(l1);
        output.add(l2);
        output.add(l3);
        output.add(l4);
        criticalConnectionsNetwork1192.criticalConnections(4, output);
        System.out.println();
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Build graph
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (List<Integer> edge : connections) {
            adjList[edge.get(0)].add(edge.get(1));
            adjList[edge.get(1)].add(edge.get(0));
        }
        boolean[] visited = new boolean[n];
        int[] arrival = new int[n];
        int[] low = new int[n];
        for (int i = 0; i < n; i++){
            if (!visited[i])
                dfs(i, -1, adjList, visited, arrival, low);
        }
        return criticalConn;
    }
    private void dfs(int node, int parent, List<Integer>[] adjList, boolean[] visited, int[] arrival, int[] low) {
        arrival[node] = timeStamp++;
        low[node] = arrival[node];
        visited[node] = true;
        for (int neighbour : adjList[node]) {
            if (!visited[neighbour])
                dfs(neighbour, node, adjList, visited, arrival, low);
            if (neighbour != parent)
                low[node] = Math.min(low[node], low[neighbour]);
            if (arrival[node] < low[neighbour])
                criticalConn.add(Arrays.asList(node, neighbour));
        }
    }
}
