package com.endava.Classloaders;

public class Main {
    public static void main(String[] args) {
        SuperClassloader scl = new SuperClassloader();
        scl.init();
        Object o = SuperClassloader.objectMap.o.get("com.endava.User");
        System.out.println(o);
    }
}
