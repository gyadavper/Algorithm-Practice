package com.gyadav.practice.educative.allPatterns.slidingwindow;
/*Problem Statement #
        Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

        Example 1:

        Input: String="aabccbb", k=2
        Output: 5
        Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".*/

import java.util.HashMap;

public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb", 2));
    }
    public static int findLength(String str, int k) {
        int startPointer = 0;
        int max = 0;
        int maxRep = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();
        for(int endPointer = 0; endPointer < str.length(); endPointer++){
            char rightCharacter = str.charAt(endPointer);
            letterFrequencyMap.put(rightCharacter, letterFrequencyMap.getOrDefault(rightCharacter, 0) + 1);
            maxRep = Math.max(maxRep, letterFrequencyMap.get(rightCharacter));

            if((endPointer - startPointer) + 1 - maxRep > k){
                letterFrequencyMap.put(str.charAt(startPointer), letterFrequencyMap.get(str.charAt(startPointer)) - 1);
                startPointer++;
            }
            max = Math.max(max, (endPointer - startPointer) + 1);
        }
        return max;
    }
}
