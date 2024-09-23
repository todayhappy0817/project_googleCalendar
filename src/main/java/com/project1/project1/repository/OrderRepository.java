package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>, OrderCustomRepository {
    @Query("SELECT DISTINCT o FROM Orders o JOIN FETCH o.users")
    List<Orders> findOrder();

    @Query("SELECT o FROM Users u JOIN Orders o where u.id = :userId")
    List<String> findOrderJoinUsers(@Param("userId") String userId);
}
