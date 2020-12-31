package com.gyadav.practice;

import java.util.ArrayList;
import java.util.List;

public class JavaListCast {
    public static void main (String[] args) {
        List<Object> objectList = new ArrayList<>();
        objectList.add("s1");
        List<String> stringList = new ArrayList<>();
        stringList.add("s2");
        objectList.add(stringList);
        List<String> strings = new ArrayList<String>();
        getFlatList(objectList, strings);
        System.out.println(strings);
    }
    public static List<String> getFlatList (List<Object> input, List<String> result) {
        for (Object o : input) {
            if (o instanceof String) {
                result.add(o.toString());
            } else {
                getFlatList((List<Object>) o, result);
            }
        }
        return result;
    }
}
