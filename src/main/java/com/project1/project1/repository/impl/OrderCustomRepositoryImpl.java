package com.project1.project1.repository.impl;


import com.project1.project1.domain.Orders;
import com.project1.project1.domain.QOrders;
import com.project1.project1.domain.QUsers;
import com.project1.project1.repository.OrderCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final QOrders qOrders = QOrders.orders;
    private final QUsers qUsers = QUsers.users;

    @Override
    public List<Orders> findAllOrders() {
        return jpaQueryFactory
                .selectFrom(qOrders)
                .join(qOrders.users, qUsers).fetchJoin()
                .fetch();
    }
}
