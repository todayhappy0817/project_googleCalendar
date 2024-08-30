package com.project1.project1.repository.impl;


import com.project1.project1.domain.Users;
import com.project1.project1.repository.UserCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserCustomRepository {
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Users> findAllUsers() {
//        return jpaQueryFactory
//                .selectFrom(Users)
//                .where(Users.)
        return null;
    }
}
