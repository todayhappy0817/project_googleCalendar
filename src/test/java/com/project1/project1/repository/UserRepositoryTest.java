package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UsersRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
//        userRepository.save(new Users("hi2"));
    }

    @Test
    @DisplayName("Update 테스트 및 특정 값 불러오기")
    public void findAndUpdate(){
        Users users3 =  Users.builder()
                                .name("d")
                                .email("s")
                                .build();
        Users user = userRepository.findByName("hi2");
        System.out.println(user.toString());
        user.setName("hi3");
        userRepository.save(user);
    }

    @Test
    @DisplayName("JPQL 테스트 실시 및 리스트 비교")
    public void findAll() {
        List<Users> users = userRepository.findAll();
        List<Users> users2 = userRepository.findUser();
        assertThat(users.toString()).isEqualTo(users2.toString());
        //특정 값을 비교하거나 String 값 비교에는 isEqualTo 를 사용하고, 객체의 참조 값(주소)를 비교할 때에는 isSameAs 를 사용한다!
    }
    @Test
    public void countAll(){
        long count = userRepository.count();
        assertThat(count).isGreaterThan(0); //숫자형 값이 특정 값보다 큰지 테스트하는 제약 조건
    }
}
