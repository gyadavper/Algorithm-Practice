package com.gyadav.practice.lc;

public class PaintHouse256 {
    public static void main (String[] a) {
        PaintHouse256 paintHouse256 = new PaintHouse256();
        int[][] costs = new int[3][3];
        costs[0] = new int[]{17,2,17};
        costs[1] = new int[]{16,16,5};
        costs[2] = new int[]{14,3,19};
        paintHouse256.minCost(costs);
    }

    public int minCost(int[][] costs) {
        // Base case
        if (costs.length == 0)
            return 0;
        int[][] table = new int[2][3];
        // Filling 1st row
        for (int i = 0; i < 3; i++)
            table[0][i] = costs[0][i];
        // Recursive case
        for (int row = 1; row < costs.length; row++) {
            for (int col = 0; col < 3; col++) {
                if (col == 0)
                table[row%2][col] = costs[row][col] + Math.min(table[(row - 1)%2][1], table[(row - 1)%2][2]);
                if (col == 1)
                    table[row%2][col] = costs[row][col] + Math.min(table[(row - 1)%2][0], table[(row - 1)%2][2]);
                if (col == 2)
                    table[row%2][col] = costs[row][col] + Math.min(table[(row - 1)%2][0], table[(row - 1)%2][1]);
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++)
            minValue = Math.min(minValue, table[(costs.length - 1)%2][i]);
        return minValue;
    }
}
