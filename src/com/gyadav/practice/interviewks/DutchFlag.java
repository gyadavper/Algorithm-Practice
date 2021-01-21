package com.gyadav.practice.interviewks;

public class DutchFlag {
    public static void dutch_flag_sort(char[] balls) {
        int start = 1, end = balls.length - 1, i = 1;
        while (i <= end) {
            if(balls[i] == 'R') {
                swap(balls, i, start);
                i++;
                start++;
            } else if (balls[i] == 'B') {
                swap(balls, i, end);
                end--;
            } else {
                i++;
            }
        }
    }
    public static void swap (char[] balls, int i, int j) {
        char temp = balls[i];
        balls[i] = balls[j];
        balls[j] = temp;
    }
    public static void main(String[] a) {
        char[] balls = new char[] {'6', 'G', 'G','B','B','R','R'};
         DutchFlag.dutch_flag_sort(balls);
        System.out.println();
    }
}
