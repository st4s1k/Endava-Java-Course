package com.endava.classloaders;

public class Main {
    public static void main(String[] args) {
        SuperClassloader scl = new SuperClassloader();
        scl.init();
        Object o = SuperClassloader.get("com.endava.User");
        System.out.println(o);
    }
}
