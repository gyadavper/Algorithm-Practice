package com.gyadav.practice.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIII170 {
    Map<Integer, Integer> valueIndexMap;
    int i;
    List<Integer> arr;
    /** Initialize your data structure here. */
    public TwoSumIII170() {
        valueIndexMap = new HashMap<>();
        i = 0;
        arr = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        valueIndexMap.put(number, i++);
        arr.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int j = 0; j <arr.size(); j++) {
            int find = value - arr.get(j);
            if (valueIndexMap.containsKey(find) && valueIndexMap.get(find) != j)
                return true;
        }
        return false;
    }
}
