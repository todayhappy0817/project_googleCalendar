package com.project1.project1.service.impl;

import com.project1.project1.aop.OauthCheck;
import com.project1.project1.domain.User;
import com.project1.project1.dto.UserDTO;
import com.project1.project1.exception.DuplicationException;
import com.project1.project1.mapper.UserMapper;
import com.project1.project1.repository.UserCustomRepository;
import com.project1.project1.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
//    @Cacheable()
    public void registerUser(UserDTO userDto) {
        User user= userMapper.toDomain(userDto);
        log.info("user 정보를 생성했습니다.{}", userMapper.toDTO(user).getName());
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
    @OauthCheck(value ="Check if user is logged in", test = "hi" , type = OauthCheck.UserType.ADMIN)
    public boolean isDuplicated(String id) {
//        if(true)
//            throw new DuplicationException("테스트중입니다");
        log.info("테스트입니다:{}", id);
        return false;
    }

    @Override
    public UserDTO getUserInfo(String id) {
        log.info("유저정보를 받아오고싶습니다.");
        return null;
    }
}
