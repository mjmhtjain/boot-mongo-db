package com.boot.simpledb;

import com.boot.simpledb.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SimpledbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpledbApplication.class, args);
    }

    @Bean
    public RedisTemplate<Long, Book> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Book> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // Add some specific configuration here. Key serializers, etc.
        return template;
    }
}