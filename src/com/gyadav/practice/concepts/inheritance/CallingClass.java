package com.gyadav.practice.concepts.inheritance;

public class CallingClass {
    public static void main (String[] args) {
        String s = "";
        s.concat("d");
        Base base = new SubA(10, "Test");
        base.printName();
    }

}
