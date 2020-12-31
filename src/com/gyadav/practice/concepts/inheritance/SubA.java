package com.gyadav.practice.concepts.inheritance;

public class SubA extends Base{
    public SubA(int n, String name) {
        super(n, name);
    }

    public void printName() {
        System.out.println("From Sub A");
    }
}
