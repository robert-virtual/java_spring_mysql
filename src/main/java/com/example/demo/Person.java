package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String email;
    public String password;
    
    public Person() {
    }
    public Person(
        // String name,
        String email,
        String password
        ) {
        // this.name = name;
        this.email = email;
        this.password = password;
    }
}


