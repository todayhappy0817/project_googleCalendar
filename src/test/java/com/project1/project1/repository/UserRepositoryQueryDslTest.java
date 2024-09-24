package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
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
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryQueryDslTest {
    @Autowired
    private UsersRepository UsersRepository;
    @Autowired
    private OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void findAll() {
        List<Users> users = UsersRepository.findAllUsers();
        List<Users> users2 = UsersRepository.findAllUsers();
        assertThat(users.get(0).getName()).isEqualTo(users2.get(0).getName());
    }

    @Test
    @Transactional
    public void findUserByName() {
        Users user = UsersRepository.findUserByUserName("hi1");
        Users user2 = UsersRepository.findUserByUserName("hi1");
        assertThat(user).isSameAs(user2);
    }
    @Test
    @Transactional
    public void findUserByAll() {
        List<Users> users = UsersRepository.findAllUsers();
        List<Users> users2 = UsersRepository.findAllUsers();
        assertThat(users).isNotSameAs(users2);
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
        entityManager.clear();
        System.out.println("작동 순서 확인용 로그입니다");
        List<Users> users2 = UsersRepository.findAllUsers();
        assertThat(users).isNotEqualTo(users2);
    }

    @Test
    @Transactional
    public void queryDSLMappedByTest(){
        System.out.println("QueryDSL로 데이터 조회 실시");
        Users users = UsersRepository.findUserByUserName("테스트입니다1111");
        System.out.println("QueryDSL로 데이터 조회한 유저의 주문 조회");
        System.out.println("데이터:"+users.getOrders());
    }

    @Test
    @Transactional
    public void Jpa_NPlusOneTest(){
        System.out.println("주문 정보 조회");
//        List<Orders> orders = orderRepository.findAll();
        List<Orders> orders = orderRepository.findAllOrders();
        for(Orders order : orders) {
            System.out.println("현재 주문번호 데이터:"+order.getId());
            System.out.println("현재 주문 데이터:"+order.getOrderData());
            System.out.println("현재 주문 데이터의 유저 정보:"+order.getUsers());
        }
    }

}
