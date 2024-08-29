package com.project1.project1.repository;

import com.project1.project1.domain.User;
import com.project1.project1.domain.Users;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UsersRepository userRepository;

    @Test
    public void findAll() {
        List<Users> users = userRepository.findAll();
        List<Users> users2 = userRepository.findUser();
//        assertThat(users).isSameAs(users2);
    }
    @Test
    public void countAll(){
//        Users user = new Users("hi2");
//        userRepository.save(user);
        long count = userRepository.count();
        System.out.println("개수:"+count);
    }
}
