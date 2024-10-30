package com.project1.project1.repository;

import com.project1.project1.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JpaSecondCacheTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void testSecondLevelCache() {
        // 첫 번째 EntityManager로 조회
        EntityManager em1 = entityManagerFactory.createEntityManager();
//        em1.getTransaction().begin();
        Users user1 = em1.find(Users.class, 33L);
//        em1.getTransaction().commit();
        em1.close();

        // 두 번째 EntityManager로 조회 (다른 영속성 컨텍스트)
        EntityManager em2 = entityManagerFactory.createEntityManager();
//        em2.getTransaction().begin();
        Users user2 = em2.find(Users.class, 33L);  // 이때는 2차 캐시에서 가져옴
//        em2.getTransaction().commit();
        em2.close();

        assertThat(user1).isEqualTo(user2);
    }

}
