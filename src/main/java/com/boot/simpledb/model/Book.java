package com.boot.simpledb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String id;
    public String name;
}
