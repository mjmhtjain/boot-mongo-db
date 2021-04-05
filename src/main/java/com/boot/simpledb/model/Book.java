package com.boot.simpledb.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    public long id;
    public String name;
}
