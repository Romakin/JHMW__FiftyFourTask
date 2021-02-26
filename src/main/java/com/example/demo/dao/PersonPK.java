package com.example.demo.dao;

import java.io.Serializable;

public class PersonPK implements Serializable {
    protected String name;
    protected String surname;
    protected int age;

    public PersonPK() { }

    public PersonPK(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
