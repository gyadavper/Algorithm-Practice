package com.gyadav.practice.educative.allPatterns.slidingwindow;

import java.util.Collections;
import java.util.HashMap;

/*Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.

        You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e.,
        you will stop when you have to pick from a third fruit type.

        Write a function to return the maximum number of fruits in both the baskets.

        Example 1:

        Input: Fruit=['A', 'B', 'C', 'A', 'C']
        Output: 3
        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']*/
public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println(findLength(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
    public static int findLength(int[] arr) {
        if(arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 1;
        int startPointer = 0;

        for (int endPointer = 0; endPointer < arr.length; endPointer++){
            map.put(arr[endPointer], endPointer);

            if(map.size() > 2) {
                int del_indx = Collections.min(map.values());
                map.remove(arr[del_indx]);
                startPointer = del_indx + 1;
            }
            maxLength = Math.max(maxLength, (endPointer - startPointer) + 1);
        }
        return maxLength;
    }
}
