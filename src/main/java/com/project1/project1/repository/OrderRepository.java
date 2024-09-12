package com.project1.project1.repository;

import com.project1.project1.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
