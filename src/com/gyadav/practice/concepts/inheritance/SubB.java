package com.gyadav.practice.concepts.inheritance;

public class SubB extends Base{
    private String name;
    public SubB(int n, String name) {
        super(n, name);
    }
    public void getName() {
        System.out.println("From SubB");
    }
}
