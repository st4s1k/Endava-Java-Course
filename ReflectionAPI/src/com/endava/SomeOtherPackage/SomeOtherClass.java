package com.endava.SomeOtherPackage;


import com.endava.DefaultValue;
import com.endava.Managed;

@Managed
public class SomeOtherClass {
    private String field1;

    @DefaultValue
    private String field2;

    @Override
    public String toString() {
        return "SomeOtherClass{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
