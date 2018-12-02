package com.endava.foodchain;

public class InvalidWordException extends Exception {
    private String word;

    public InvalidWordException(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
