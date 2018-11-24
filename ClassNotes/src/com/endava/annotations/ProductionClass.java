package com.endava.annotations;

@Author("Debil")
@Deprecated
public class ProductionClass {

}

@Author(value = "21", name = "Stanislav", date = "12-12-1996")
class X {
    void foo() {

    }
}

class Y extends X {
    void foo() {

    }
}