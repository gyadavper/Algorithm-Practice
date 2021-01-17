package com.gyadav.practice.ctci.ch10;

public class Search2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int subStart = 0, subEnd = matrix.length, start = 0, end = matrix[0].length, subIndex = -1;
        while (subStart <= subEnd) {
            int mid = subStart + (subEnd - subStart) / 2;
            if (matrix[mid][0] <= target && matrix[mid][end] >= target) {
                subIndex = mid;
                break;
            }
            if (matrix[mid][0] < target && matrix[mid][end] < target)
                subStart = mid + 1;
            else
                subEnd = mid - 1;
        }
        if (subIndex == -1)
            return false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[subIndex][mid] == target)
                return true;
            if (matrix[subIndex][mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }
}
