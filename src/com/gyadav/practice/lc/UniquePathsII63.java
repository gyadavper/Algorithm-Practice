package com.gyadav.practice.lc;

public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] table = new int[Math.min(2, m)][n];
        // Base Case
        if (obstacleGrid[0][0] == 1)
            return 0;
        table[0][0] = 1;
/*        for (int row = 1; row < table.length; row++) {
            if (obstacleGrid[row][0] == 1)
                break;
            table[row][0] = 1;
        }*/
        for (int col = 1; col < n; col++) {
            if (obstacleGrid[0][col] == 1)
                break;
            table[0][col] = 1;
        }
        // Recursive case
        for (int row = 1; row < m; row++) {
            if (obstacleGrid[row][0] == 0)
                table[row%2][0] = table[(row-1)%2][0];
            else
                table[row%2][0] = 0;
            for (int col = 1; col < n; col++) {
                if (obstacleGrid[row][col] == 1)
                    table[row%2][col] = 0;
                else
                    table[row%2][col] = table[row%2][col - 1] + table[(row - 1)%2][col];
            }
        }
        return table[(m - 1)%2][n - 1];
    }
}
