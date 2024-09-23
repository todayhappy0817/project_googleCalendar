package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>, OrderCustomRepository {
    @Query("SELECT DISTINCT u FROM Orders u JOIN FETCH u.users")
    List<Orders> findOrder();
}
