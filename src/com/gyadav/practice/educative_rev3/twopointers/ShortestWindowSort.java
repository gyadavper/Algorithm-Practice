package com.gyadav.practice.educative_rev3.twopointers;

public class ShortestWindowSort {
    public static int sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        for (int i = 1; i < arr.length;i++) {
            if (arr[left] <= arr[i])
                left++;
            else
                break;
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[right] >= arr[i])
                right--;
            else
                break;
        }
        if (left == arr.length - 1 && right == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int lIndex = left;
        int rIndex = right;
        while (lIndex <= rIndex) {
            min = Math.min(min, arr[lIndex]);
            max = Math.max(max, arr[lIndex]);
            lIndex++;
        }
        while (left > 0 && arr[left - 1] > min)
            left--;
        while (right < arr.length - 1 && arr[right + 1] < max)
            right++;
        return right - left + 1;
    }
    public static void main(String[] args) {
        //System.out.println(ShortestWindowSort.sort(new int[] { 1,3,2,2,2 }));
       System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        //System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
          //System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
