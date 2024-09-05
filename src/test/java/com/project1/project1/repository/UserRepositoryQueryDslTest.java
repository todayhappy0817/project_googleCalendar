package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryQueryDslTest {
    @Autowired
    private UsersRepository UsersRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void findAll() {
        List<Users> users = UsersRepository.findAllUsers();
        List<Users> users2 = UsersRepository.findAllUsers();
        assertThat(users.get(0).getName()).isEqualTo(users2.get(0).getName());
    }

    @Test
    public void findUserByName() {
        Users user = UsersRepository.findUserByUserName("hi1");
        Users user2 = UsersRepository.findUserByUserName("hi1");
        assertThat(user).isSameAs(user2);
    }

    @Test
    @Rollback(false)
    @Transactional
    public void JpaSaveTest(){
        Users user = UsersRepository.findById(33L).orElse(null);
        List<Users> users = UsersRepository.findAllUsers();
    }

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("1차 캐시 테스트")
    public void queryDSLCashTest(){
        List<Users> users = UsersRepository.findAllUsers();
        System.out.println("user:"+users.get(0).getName());
        UsersRepository.updateUser(users.get(0).getName());
        entityManager.flush();
        //entityManager.clear();
        System.out.println("작동 순서 확인용 로그입니다");
        List<Users> users2 = UsersRepository.findAllUsers();
        System.out.println("user2:"+users2.get(0).getName());
        assertThat(users.get(0).getName()).isNotEqualTo(users2.get(0).getName());
        //assertThat(users).isNotEqualTo(users2);
    }
}
