package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
import com.project1.project1.domain.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Orders, Long>, OrderCustomRepository {
//    @Override
//    @EntityGraph(attributePaths = {"users"})
//    List<Orders> findAll();
    @Query("SELECT DISTINCT o FROM Orders o JOIN FETCH o.users")
    List<Orders> findOrder();
    @Query(value = "select O.ORDER_DATA ,u.name from Orders O join Users u where o.USERS_ID = u.id", nativeQuery=true)
    List<Map<String,String>> findOrderJoinUsers();
}
