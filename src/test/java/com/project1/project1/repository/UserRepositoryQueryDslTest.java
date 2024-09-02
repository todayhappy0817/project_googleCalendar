package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        List<Users> users2 = userCustomRepository.findAllUsers();
        assertThat(users.get(0).getName()).isEqualTo(users2.get(0).getName());
    }
    @Test
    public void findUserByName() {
        Users user = userCustomRepository.findUserByUserName("hi1");
        Users user2 = userCustomRepository.findUserByUserName("hi1");
        assertThat(user.getName()).isEqualTo(user2.getName());
    }
    @Test
    @DisplayName("1차 캐시 테스트")
    public void queryDSLCashTest(){
        List<Users> users = userCustomRepository.findAllUsers();
        System.out.println("user:"+users.get(0).getName());
        userCustomRepository.updateUser(users.get(0).getName());
        List<Users> users2 = userCustomRepository.findAllUsers();
        System.out.println("user2:"+users2.get(0).getName());
        assertThat(users.get(0).getName()).isNotEqualTo(users2.get(0).getName());
    }
}
