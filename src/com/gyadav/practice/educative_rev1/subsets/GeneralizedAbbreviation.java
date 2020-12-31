package com.gyadav.practice.educative_rev1.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbString {
 String abb;
 int currentPos;

    public AbbString(String abb, int currentPos) {
        this.abb = abb;
        this.currentPos = currentPos;
    }
}
public class GeneralizedAbbreviation {
    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        Queue<AbbString> queue = new LinkedList<>();
        queue.add(new AbbString("",-1));
        for (int i = 0; i < word.length(); i++) {

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                AbbString current = queue.poll();
                queue.add(new AbbString(current.abb + word.charAt(i), current.currentPos+ 1));
                if (current.abb.length() > 0 && Character.isDigit(current.abb.charAt(current.currentPos))) {
                    int currentInt = Character.valueOf(current.abb.charAt(current.currentPos)) + 1;
                    String currentString = Character.toString((char) currentInt);
                    String replace = current.abb.replace(current.abb.charAt(current.currentPos), currentString.charAt(0) );
                    if (current.currentPos == word.length())
                    queue.add(new AbbString(replace, current.currentPos));
                } else {
                    queue.add(new AbbString(current.abb + '1', current.currentPos+ 1));
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll().abb);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
