package com.gyadav.practice.educative.allPatterns.twopointer;
public class BackspaceCompare {
    public static void main(String[] a){
        System.out.println(compare("xy#z", "xzz#"));
    }
    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >=0) {
            int i1 = nextValidIndex(str1, index1);
            int i2 = nextValidIndex(str2, index2);
            if(i1 < 0 && i2 < 0){
                return true;
            }
            if (i1 < 0 || i2 < 0){
                return false;
            }
            if(str1.charAt(i1) != str2.charAt(i2)){
                return false;
            }
            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return index1 == index2;
    }

    private static int nextValidIndex (String str, int index) {
        int backtrack = 0;
        while (index >= 0) {
            if(str.charAt(index) == '#'){
                backtrack++;
            } else if (backtrack > 0) {
                backtrack--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
