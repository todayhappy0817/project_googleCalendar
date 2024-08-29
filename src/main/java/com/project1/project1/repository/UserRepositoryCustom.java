package com.project1.project1.repository;


import com.project1.project1.domain.Users;

import java.util.List;

public interface UserRepositoryCustom {
    List<Users> findAllUsers();
}
