package com.example.nikan.task3;

public class Person {

    private String name;
    private long id;

    public Person(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
