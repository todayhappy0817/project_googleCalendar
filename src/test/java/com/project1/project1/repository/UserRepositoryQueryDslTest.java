package com.project1.project1.repository;

import ch.qos.logback.core.CoreConstants;
import com.project1.project1.domain.Orders;
import com.project1.project1.domain.Users;
import com.project1.project1.dto.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryQueryDslTest {
    @Autowired
    private UsersRepository UsersRepository;
    @Autowired
    private OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UsersRepository usersRepository;

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
    @Test
    @Rollback(false)
    public void JPA_TransactionalTest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            try {
                JPA_TransactionalRepeatable_Read();
            } finally {
                latch.countDown();
            }
        });

        thread.start();
        Thread.sleep(2000);
        JPA_TransactionalRepeatableTest();
        latch.await(); // Wait for the thread to finish
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Rollback(false)
    public void JPA_TransactionalRepeatable_Read() {
        System.out.println("특정 유저 정보 조회");
        Users user = UsersRepository.findUserByUserName("이준원2");
        System.out.println("대기 이전 데이터: " + user.getEmail());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user = UsersRepository.findUserByUserName("이준원2");
        System.out.println("대기 이후 데이터: " + user.getEmail());
    }

    @Transactional
    @Rollback(false)
    public void JPA_TransactionalRepeatableTest() {
        Users user = UsersRepository.findUserByUserName("이준원2");
        user.setEmail(user.getEmail() + ".com");
        UsersRepository.save(user);
        System.out.println("데이터 수정 완료");
    }

    @Test
    @Rollback(false)
    @DisplayName("더티 리드 테스트")
    public void transactional_DirtyRead() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(()-> {
            try{
                transactional_DirtyRead_Update();
            }
            finally {
                latch.countDown();
            }
        });
        thread.start();
        Thread.sleep(2000);
        String email = transactional_DirtyRead_Read();
        latch.await();
        System.out.println("현재 이메일 정보:"+email);
        assertThat(email).isEqualTo("h2test4@naver.com");
    }

//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Transactional
    public void transactional_DirtyRead_Update(){
        Users user = UsersRepository.findUserByUserName("이준원3");
        user.setEmail("h2test3@naver.com");
        entityManager.flush();
        System.out.println("데이터 수정 완료");
        try {
            Thread.sleep(10000); //트랜잭션 2가 읽을 시간을 주기 위해 대기
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
//        if(true) throw new RuntimeException("DDD");
        System.out.println("데이터 저장 실시");
    }
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Transactional
    public String transactional_DirtyRead_Read(){
        Users user = UsersRepository.findUserByUserName("이준원3");
        return user.getEmail();
    }

    @Test
    public void UserDtoTest(){
        List<UserDTO> userDTOS = usersRepository.findAllUserDTOs();
        for(UserDTO userDTO : userDTOS){
            System.out.println("유저 정보"+ userDTO.toString());
        }
    }
}
