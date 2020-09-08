package com.gyadav.practice.lc;

public class SingleNumber2 {
    public static int findSingleNumber(int[] arr) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : arr) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2,2,3,2,9 };
        int result = SingleNumber2.findSingleNumber(arr);
        System.out.println(result);
        // System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

/*        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);*/
    }
}
