package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule207 {
    int timestamp = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build graph
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<>();
        for (int[] preReq : prerequisites)
            adjList[preReq[1]].add(preReq[0]);
        boolean[] visited = new boolean[numCourses];
        int[] arrival = new int[numCourses];
        int[] departure = new int[numCourses];
        // Outer loop
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic_dfs(i, adjList, visited, arrival, departure))
                    return false;
            }
        }
        return true;
    }
    private boolean isCyclic_dfs(int node, List<Integer>[] adjList, boolean[] visited, int[] arrival, int[] departure) {
        visited[node] = true;
        arrival[node] = timestamp++;
        for (int neighbour : adjList[node]) {
            if (!visited[neighbour]) {
                if (isCyclic_dfs(neighbour, adjList, visited, arrival, departure))
                    return true;
            } else if (departure[neighbour] == 0)
                return true;
        }
        departure[node] = timestamp++;
        return false;
    }
}
