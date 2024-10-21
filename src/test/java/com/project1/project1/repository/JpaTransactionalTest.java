package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
public class JpaTransactionalTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional
    public void saveUsers(){ //계정 생성
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    @Rollback(false)
    public void updateUsers(){ //이메일 정보 저장
        Users users = usersRepository.findUserByUserName("트랜잭션관리테스트");
        users.setEmail("wow6@gmail.com");
        usersRepository.save(users);
    }
    @Test
    @Transactional(propagation = Propagation.NEVER)
    public void getEmailUsers(){ //이메일 정보 조회
//        usersRepository.save(Users.builder().name("트랜잭션관리테스트").build());
        Users users = usersRepository.findUserByUserName("트랜잭션관리테스트");
        System.out.println("이메일 정보"+users.getEmail());
   }

}
