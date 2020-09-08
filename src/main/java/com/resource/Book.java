package com.resource;

import lombok.Data;

/**
 * @date:2020/9/6 22:24
 **/
@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private int year;
    private double price;
}
