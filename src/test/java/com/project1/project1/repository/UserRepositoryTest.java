package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
import com.project1.project1.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager entityManager;

//    @BeforeEach
    public void setUp() {
        //userRepository.deleteAll();
        //userRepository.save(Users.builder().name("hi2").build());
    }

    @Test
    @DisplayName("Update 테스트 및 특정 값 불러오기")
    public void findAndUpdate(){
        Users user = userRepository.findByName("hi5");
        System.out.println(user.toString());
        user.setName("hi5");
        userRepository.save(user);
    }

    @Test
    @DisplayName("1차 캐시 사용 여부 확인")
    @Transactional
    public void findByID(){
        Users user = userRepository.findById(33L).orElse(null);
        Users user2 = userRepository.findById(33L).orElse(null); //1차 캐시를 사용하는 경우는 식별자로 조회하였을 경우 발동
        assertThat(entityManager.contains(user) && entityManager.contains(user2)).isTrue();
    }

    @Test
    @DisplayName("1차 캐시 테스트")
    @Transactional
    public void findByAll(){
        List<Users> users = userRepository.findAll();
        List<Users> users2 = userRepository.findAll();
        assertThat(users).isNotSameAs(users2);
    }

    @Test
    @Transactional
    @DisplayName("1차 캐싱과 쓰기 지연 테스트")
    @Rollback(false)
    public void jpaCashTest() {
        Users user = userRepository.findById(33L).orElse(null);
        /*
        * entityManager.close(); 영속성 컨텍스트를 아예 사용하지 않겠다는 의미
        * 그런데 @Transactional 사용 때문에 이후 재사용되는 것으로 보임
        */ 
        user.setName(user.getName()+"!");
        userRepository.save(user);
        System.out.println("작동 순서 확인용 로그입니다");
        Users user2 = userRepository.findById(33L).orElse(null);
        assertThat(user.getName()).isEqualTo(user2.getName());
        assertThat(user).isSameAs(user2); //같은 객체의 참조 값(주소)를 비교할 때 사용
    }

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("JPQL에서 지연 쓰기 테스트")
    public void jpqlLazyTest(){
        List<Users> users = userRepository.findAll();
        users.get(1).setName(users.get(1).getName()+"!");
        userRepository.save(users.get(1));
        System.out.println("작동 순서 확인용 로그입니다");
        System.out.println("작동 순서 확인용 로그입니다");
        System.out.println("작동 순서 확인용 로그입니다");
        entityManager.flush();
        entityManager.clear();
        List<Users> users2 = userRepository.findAll();
        assertThat(users).isNotEqualTo(users2);
    }

    @Test
    @DisplayName("JPQL 테스트 실시 및 리스트 비교")
    public void findAll() {
        List<Users> users = userRepository.findUser();
        List<Users> users2 = userRepository.findUser();
        assertThat(users).isNotSameAs(users2);
    }

    @Test
    public void countAll(){
        long count = userRepository.count();
        assertThat(count).isGreaterThan(0); //숫자형 값이 특정 값보다 큰지 테스트하는 제약 조건
    }

    @Test
    @Transactional
    @Rollback(false)
    public void insertJPAOrderService(){
        Users user = userRepository.findById(33L).orElse(null);
        assert user != null;
        System.out.println(user.getOrders());
        Orders orders = orderRepository.findById(2L).orElse(null);
        assert orders != null;
        System.out.println("오더 정보"+orders.getUsers());
//        orderRepository.save(Orders.builder().orderData("아이스커피")
//                            .users(user)
//                            .build());
    }

    @Test
    public void insertOrderService(){
        //SELECT u from Users u where u.name = :username
        Users users = userRepository.findUsersById("이준원"); //유저 정보 조회
        assert users != null;
        //insert into ORDERS(orderData,customer_id) values('아이템1',3L)
//        orderRepository.insertOrder("아이템1",users.getId()); //주문정보 및 유저_id(외래키 값)로 데이터 생성
    }

}
