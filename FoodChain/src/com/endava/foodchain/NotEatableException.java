package com.endava.foodchain;

public class NotEatableException extends Exception {
    private String prayClass;

    public NotEatableException(ApexPredator pray) {
        prayClass = pray.getClass().getSimpleName();
    }

    public String getPrayClass() {
        return prayClass;
    }
}
