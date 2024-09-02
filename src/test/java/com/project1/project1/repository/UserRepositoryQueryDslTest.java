package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryQueryDslTest {

    @Autowired
    @Qualifier("customRepository")
    private UserCustomRepository userCustomRepository;

    @Test
    public void findAll() {
        List<Users> users = userCustomRepository.findAllUsers();
        Users user = userCustomRepository.findUserByUserName("hi3");
        assertThat(users.get(0).getName()).isEqualTo(user.getName());
    }
}
