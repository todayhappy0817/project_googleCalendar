package com.project1.project1.service.impl;

import com.project1.project1.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;


    @Test
    @DisplayName("서비스 테스트 세팅")
    public void testGetUserInfo(){
        assertThat(false).isSameAs(userService.isDuplicated("hi"));
    }
}