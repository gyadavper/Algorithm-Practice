package com.gyadav.practice.interviewks.sorting;

public class DutchFlag {
    public static void dutch_flag_sort(char[] balls) {
        int start = 0, end = balls.length - 1, i = 1;
        while (i <= end) {
            if(balls[i] == 'R') {
                swap(balls, i, start);
                i++;
                start++;
            } else if (balls[i] == 'B') {
                swap(balls, i, end);
                end--;
            } else if (balls[i] == 'G'){
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
        char[] balls = new char[] {'2', 'B', 'G'};
         DutchFlag.dutch_flag_sort(balls);
        System.out.println();
    }
}
