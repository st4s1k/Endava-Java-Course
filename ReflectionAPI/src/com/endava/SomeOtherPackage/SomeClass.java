package com.endava.SomeOtherPackage;


import com.endava.DefaultValue;
import com.endava.Managed;

@Managed
public class SomeClass {
    @DefaultValue
    private String field1;

    private String field2;

    @Override
    public String toString() {
        return "SomeClass{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
