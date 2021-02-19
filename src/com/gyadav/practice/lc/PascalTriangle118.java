package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle118 {
    public static void main(String[] a) {
        PascalTriangle118 pascalTriangle118 = new PascalTriangle118();
        pascalTriangle118.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if (numRows == 0)
            return pascalTriangle;
        if (numRows >= 1)
            pascalTriangle.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows >=2)
            pascalTriangle.add(new ArrayList<>(Arrays.asList(1,1)));
        for (int row = 2; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int col = 1; col < row; col++) {
                currentRow.add(pascalTriangle.get(row - 1).get(col - 1) + pascalTriangle.get(row - 1).get(col));
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
        }
        return pascalTriangle;
    }
}
