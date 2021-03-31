package com.wk.leetcode.kuaishou;

public class Derived extends Base {
    public Derived() {
        System.out.println("Derived");
    }

    public Derived(int c) {
        super(c);
        System.out.println("Derived--" + c);
    }

    public static void main(String[] args) {
        Derived a = new Derived();
        Derived b = new Derived(33);
    }
}
