package com.endava.streamapi;

import java.time.LocalDateTime;
import lombok.Data;

@Data public class User {
    private final String name;
    private boolean isActive;
    private String[] roles;
    private String[] emails;
    private Double balance;
    private final LocalDateTime registrationDate;

    public User(String name, String[] roles, String[] emails) {
        this.name = name;
        isActive = true;
        this.roles = roles;
        this.emails = emails;
        balance = 0d;
        registrationDate = LocalDateTime.now();
    }
}