package com.endava.foodchain;

public class NotEatableException extends Exception {
    private String predatorClass;
    private String prayClass;

    public NotEatableException(String predatorClass, String prayClass) {
        this.predatorClass = predatorClass;
        this.prayClass = prayClass;
    }

    public String getPrayClass() {
        return prayClass;
    }

    public String getPredatorClass() {
        return predatorClass;
    }
}
