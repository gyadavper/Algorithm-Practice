package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakesandLadders909 {
    public static void main(String[] a) {
        SnakesandLadders909 snakesandLadders909 = new SnakesandLadders909();
        int[][] board = new int[5][5];
        board[0] = new int[]{-1,-1,19,10,-1};
        board[1] = new int[]{2,-1,-1,6,-1};
        board[2] = new int[]{-1,17,-1,19,-1};
        board[3] = new int[]{25,-1,20,-1,-1};
        board[4] = new int[]{-1,-1,-1,-1,15};
        //board[5] = new int[]{-1, 15, -1, -1, -1, -1};
        System.out.println(snakesandLadders909.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        int length = board.length * board.length;
        // Build graph
        List<Integer>[] adjList = new List[length];
        for (int i = 0; i < length; i++)
            adjList[i] = new ArrayList<>();
        int counter = 0;
        int[] flatBoard = new int[length];
        boolean leftToRight = true;
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 0; col < board.length; col++) {
                if (leftToRight) {
                    flatBoard[counter++] = board[row][col];
                }else {
                    flatBoard[counter++] = board[row][board.length - 1 - col];
                }
            }
            leftToRight = !leftToRight;
        }
        for (int i = 0; i < flatBoard.length; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i + dice < flatBoard.length)
                    if (flatBoard[i + dice] == -1)
                        adjList[i].add(i + dice);
                    else
                        adjList[i].add(flatBoard[i + dice] - 1);
            }
        }
        // BFS
        boolean[] visited = new boolean[length];
        int[] distance = new int[length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : adjList[current]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    distance[neighbour] = distance[current] + 1;
                    queue.offer(neighbour);
                }
                if (neighbour == length - 1)
                    return distance[length - 1];
            }
        }
        return -1;
    }
}
