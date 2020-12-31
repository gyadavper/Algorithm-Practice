package com.gyadav.practice.educative.allPatterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
    String str;
    int openCount;
    int closeCount;
    public ParenthesesString (String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}
public class GenerateParentheses {
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num)
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount+1, ps.closeCount));
                if (ps.openCount > ps.closeCount)
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }
        return result;
    }
}
