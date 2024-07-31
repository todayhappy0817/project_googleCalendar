package com.project1.project1.service.impl;

import com.project1.project1.dto.UserDTO;
import com.project1.project1.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserDTO userDto) {
        log.info("user 정보를 생성했습니다.");
    }
    @Override
    public UserDTO login(String id, String Password) {
        return null;
    }

    @Override
    public boolean logout(String id) {
        return false;
    }

    @Override
    public boolean changePassword(String id, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public boolean isDuplicated(String id) {
        log.info("테스트입니다.");
        return false;
    }

    @Override
    public UserDTO getUserInfo(String id) {
        log.info("유저정보를 받아오고싶습니다.");
        return null;
    }
}
