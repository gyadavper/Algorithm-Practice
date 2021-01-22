package com.gyadav.practice.educative_rev3.twopointers;

public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int i1 = str1.length() - 1, i2 = str2. length() - 1;
        while (i1 >= 0 && i2 >= 0) {
            while (i1 >= 0 && str1.charAt(i1) == '#')
                i1 = nextValidIndex(str1, i1);
            while (i2 >= 0 && str2.charAt(i2) == '#')
                i2 = nextValidIndex(str2, i2);
            if(i1 < 0 || i2 < 0)
                break;
            if (str1.charAt(i1) != str2.charAt(i2))
                return false;
            i1--;
            i2--;
        }
        return i1 == i2;
    }
    public static int nextValidIndex(String str, int index) {
        int characterToSkip = 0;
        while (index >= 0 && str.charAt(index) == '#') {
            characterToSkip++;
            index--;
        }
        return index - characterToSkip;
    }
    public static void main(String[] a) {
        System.out.println(BackspaceCompare.compare("bxj##tw", "bxo#j##tw"));
    }
}
