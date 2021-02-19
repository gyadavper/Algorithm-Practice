package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {
    public static void main(String[] a) {
        Triangle120 triangle120 = new Triangle120();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(2)));
        lists.add(new ArrayList<>(Arrays.asList(3,4)));
        lists.add(new ArrayList<>(Arrays.asList(6,5,7)));
        lists.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        triangle120.minimumTotal(lists);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // Base case
        if (triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int[][] table = new int[triangle.size()][triangle.size()];
        table[0][0] = triangle.get(0).get(0);
        // Recursive case
        for (int row = 1; row < triangle.size(); row++) {
            table[row][0] = triangle.get(row).get(0) + table[row - 1][0];
            for (int col = 1; col < row; col++) {
                table[row][col] = triangle.get(row).get(col) + Math.min(table[row - 1][col - 1], table[row - 1][col]);
            }
            table[row][row] = triangle.get(row).get(row) + table[row - 1][row - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++)
            min = Math.min(table[triangle.size() - 1][i], min);
        return min;
    }
}
