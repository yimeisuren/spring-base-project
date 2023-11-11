package org.example.domain;

import lombok.Data;

@Data
public class Book {
    private String name;
    private Author author;
    private Integer price;
}
