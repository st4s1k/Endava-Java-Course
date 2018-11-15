package com.endava.streamapi;

import java.time.LocalDate;
import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = false)
public class User {
    private       Role      role;
    private       Boolean   isActive;
    private final LocalDate registrationDate;
    private       Double    balance;
    private final String    name;
    private       String    email;

    public User(String name, Role role, String email) {
        this.name = name;
        isActive = true;
        this.role = role;
        this.email = email;
        balance = 0d;
        registrationDate = LocalDate.now();
    }
}