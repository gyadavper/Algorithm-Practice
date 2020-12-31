package com.gyadav.practice.educative_rev1.twoPointers;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int s1P = str1.length() - 1;
        int s2P = str2.length() - 1;
        int s1Skip = 0, s2Skip = 0;
        while (s1P >= 0 && s2P >= 0) {
            char s1 = str1.charAt(s1P);
            char s2 = str2.charAt(s2P);
            while (s1P >=0 && s1 == '#') {
                s1Skip++;
                s1P--;
                s1 = str1.charAt(s1P);
            }
            while (s2P >=0 && s2 == '#') {
                s2Skip++;
                s2P--;
                s2 = str2.charAt(s2P);
            }
            s1P = s1P - s1Skip;
            s2P = s2P - s2Skip;
            s1 = str1.charAt(s1P);
            s2 = str2.charAt(s2P);
            if (s1 != s2)
                return false;
            if (s1 == s2) {
                s1P--;
                s2P--;
            }
            s1Skip = 0;
            s2Skip = 0;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
