package com.gyadav.practice.educative.dpPattern.commonSubstring;

public class SPM {
    public static void main(String[] a) {
        SPM spm = new SPM();
        System.out.println(spm.calculatePatternMatching("baxmx", "ax"));
        System.out.println(spm.calculatePatternMatching("tomorrow", "tor"));
    }

    public int calculatePatternMatching(String str, String pat) {
        // every empty pattern has one match
        if(pat.length() == 0)
            return 1;

        if(str.length() == 0 || pat.length() > str.length())
            return 0;

        // dp[strIndex][patIndex] will be storing the count of SPM up to str[0..strIndex-1][0..patIndex-1]
        int[][] dp = new int[str.length()+1][pat.length()+1];

        // for the empty pattern, we have one matching
        for(int i=0; i<=str.length(); i++)
            dp[i][0] = 1;

        for(int strIndex=1; strIndex<=str.length(); strIndex++) {
            for(int patIndex=1; patIndex<=pat.length(); patIndex++) {
                if(str.charAt(strIndex-1) == pat.charAt(patIndex-1))
                    dp[strIndex][patIndex] = dp[strIndex-1][patIndex-1];
                dp[strIndex][patIndex] += dp[strIndex-1][patIndex];
            }
        }

        return dp[str.length()][pat.length()];
    }

    public int patternMatchingRecursive(String input, String pattern,int i1, int i2) {
        if (i2 == pattern.length())
            return 1;
        if (i1 == input.length())
            return 0;
        int c1 = 0;
        if (input.charAt(i1) == pattern.charAt(i2)) {
            c1 = patternMatchingRecursive(input, pattern, i1 + 1, i2 + 1);
        }
        int c2 = patternMatchingRecursive(input, pattern, i1 + 1, i2);
        return c1 + c2;
    }
}
