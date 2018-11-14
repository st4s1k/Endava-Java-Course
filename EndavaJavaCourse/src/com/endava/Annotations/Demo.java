package com.endava.Annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")

public class Demo {
    public static void main(String[] args) {
        ProductionClass productionClass = new ProductionClass();

        System.out.println("\nClassloader for class " +
                productionClass.
                        getClass().
                        getSimpleName() +
                " is " +
                productionClass
                        .getClass()
                        .getClassLoader()
                        .getName() +
                "\n"
        );

        User user = new User();

//        Double uName = user.getWeight();
//
//        System.out.println(user.getWeight());

        Class<?> userClass = User.class;

        Method[] methods = userClass.getMethods();

        for (Field f: userClass.getDeclaredFields()) {
            System.out.println("Field: " + f.getName());
        }

        System.out.println();

        for (Method m: methods) {
            System.out.println("Method: " + m.getName());
        }
    }
}
