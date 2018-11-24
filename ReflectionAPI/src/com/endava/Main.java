package com.endava;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClasspathScanner cps = new ClasspathScanner();

        List<Object> ol = cps.getObjects("com/endava/SomeOtherPackage");

        System.out.println("\n\t" + ol);
    }
}
