package com.busyzero.demo.javaassist.demo;

public class OriginalPerson {
    private String name;

    public String resetName(String name) {
        this.name = name;
        return this.name;
    }
}
