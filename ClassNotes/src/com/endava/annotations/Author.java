package com.endava.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@interface Author {
    String value();
    String name() default "Vasily";
    String date() default "14-11-2018";
}

@Target(ElementType.PARAMETER)
@interface Artist {
    String name();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Programmer {
    String name() default "Piotr";
    String date() default "24-13-1918";
}