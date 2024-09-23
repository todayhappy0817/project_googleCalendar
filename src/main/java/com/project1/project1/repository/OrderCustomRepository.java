package com.project1.project1.repository;


import com.project1.project1.domain.Orders;

import java.util.List;

public interface OrderCustomRepository {
    List<Orders> findAllOrders();
}
