package com.example.demo.batch.model;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String hobby;
    private int age;

    public Person(String name, String hobby, int age) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
    }

    public Person() {

    }
}
