package com.gyadav.practice.educative.allPatterns.bitwiseXOR;

public class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        System.out.println(1^0);
        System.out.println(1^1);
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x = x ^ arr[i];
        }
        return x;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int result = SingleNumber.findSingleNumber(arr);
       // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

/*        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);*/
    }
}
