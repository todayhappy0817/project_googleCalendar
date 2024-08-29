package com.project1.project1.repository.impl;


import com.project1.project1.domain.Users;
import com.project1.project1.repository.UserRepositoryCustom;
import com.project1.project1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class UsersRepositoryimpl implements UserRepositoryCustom {
    @Autowired
    private UsersRepository userRepository;

    @Override
    public List<Users> findAllUsers() {
        return List.of();
    }
}
