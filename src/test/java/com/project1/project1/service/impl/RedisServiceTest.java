package com.project1.project1.service.impl;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RedisServiceTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void testStringRedisTemplate() {
        List<String> t = List.of("S1", "S2");
        redisTemplate.opsForValue().set("key3", t);
        //assertThat(value).isEqualTo(t);
    }
}
