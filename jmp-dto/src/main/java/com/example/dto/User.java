package com.example.dto;

import java.time.LocalDate;

public class User {
    private String name;
    private String surName;
    private LocalDate birthDay;

    public User() {
    }

    public User(String name, String surName, LocalDate birthDay) {
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
