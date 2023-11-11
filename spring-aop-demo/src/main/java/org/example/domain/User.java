package org.example.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Address address;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
