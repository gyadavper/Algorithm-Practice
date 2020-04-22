package com.gyadav.practice.educative.twopointer;

import java.util.Arrays;
/*[3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1]
3
        System.out.println("[" +arr[i] + ", "+ arr[left]+", "+arr[right]+"]");*/
public class TripletWithSmallerSum {
    public static void main(String[] args){
        System.out.println(searchTriplets(new int[] { 3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1 }, 3));
    }
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    System.out.println("[" +arr[i] + ", "+ arr[left]+", "+arr[right]+"]");
                    count = count + (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
