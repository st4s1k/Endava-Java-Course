package com.endava.streamapi;

import java.time.LocalDateTime;
import lombok.Data;

@Data public class User {
    private final String name;
    private boolean isActive;
    private String roles;
    private String emails;
    private Double balance;
    private final LocalDateTime registrationDate;
}