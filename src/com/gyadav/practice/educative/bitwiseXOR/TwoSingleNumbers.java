package com.gyadav.practice.educative.bitwiseXOR;
/*https://www.youtube.com/watch?v=3TSC0nlur58*/
public class TwoSingleNumbers {
    public static int[] findSingleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum ^= num;
        int lowBit = sum & (-sum);
        int[] result = new int[2];
        for (int num : nums) {
            if ((lowBit & num) == 0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 4, 7, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
