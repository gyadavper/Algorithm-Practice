package com.gyadav.practice.educative.allPatterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Abbrevate {
    StringBuilder str;
    int start;
    int count;

    public Abbrevate(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        Queue<Abbrevate> queue = new LinkedList<>();
        queue.add(new Abbrevate(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            Abbrevate current = queue.poll();
            if (current.start == word.length()) {
                if (current.count != 0)
                    current.str.append(current.count);
                result.add(current.str.toString());
            } else {
                queue.add(new Abbrevate(new StringBuilder(current.str), current.start + 1, current.count + 1));
                if (current.count != 0)
                    current.str.append(current.count);

                queue.add(new Abbrevate(new StringBuilder(current.str).append(word.charAt(current.start)), current.start + 1, 0));
            }
        }
        return result;
    }
}
