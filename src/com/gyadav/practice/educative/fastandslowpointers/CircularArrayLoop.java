package com.gyadav.practice.educative.fastandslowpointers;

public class CircularArrayLoop {
    public static void main(String[] args) {
       // System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 3,1,2}));
        //System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int slow = i, fast =i;
            boolean isForward = arr[i] > 0;
             do {
                 slow = getNextIndex (arr, slow, isForward);
                 fast = getNextIndex (arr, fast, isForward);
                 if(fast != -1)
                     fast = getNextIndex (arr, fast, isForward);
             } while (slow != -1 && fast!= -1 && slow != fast);
            if ( slow != -1 && slow == fast)
                return true;
        }
        return false;
    }

    private static int getNextIndex(int[] arr, int i, boolean isForward) {
        if(isForward != arr[i] > 0)
            return -1;
        int nextIndex = (i + arr[i]) % arr.length;
        if(nextIndex < 0)
            nextIndex = arr.length + nextIndex;
        if(i == nextIndex)
            return -1;
        return nextIndex;
    }
}
