package com.gyadav.practice.concepts.inheritance;

public class Base {
    private int n;
    private String name;

    public Base(int n, String name) {
        this.n = n;
        this.name = name;
    }

    public void printName () {
        System.out.println(this.name);
    }
}
