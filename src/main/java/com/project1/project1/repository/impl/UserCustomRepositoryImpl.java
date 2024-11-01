package com.project1.project1.repository.impl;


import com.project1.project1.domain.QUsers;
import com.project1.project1.domain.Users;
import com.project1.project1.dto.UserDTO;
import com.project1.project1.repository.UserCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUsers users = QUsers.users;
    @Override
    public List<Users> findAllUsers() {
        return jpaQueryFactory
                .selectFrom(users)
                //.where(users.name.eq("hi3"))
                .fetch(); // List 메서드는 List<Users> 타입을 반환한다.
    }
    @Override
    public Users findUserByUserName(String username){
        return jpaQueryFactory
                .selectFrom(users)
                .where(users.name.eq(username))
                .fetchOne(); //단일 조건을 원할 경우
    }
    @Override
    public void updateUser(String username){
        jpaQueryFactory.update(users)
                .set(users.name,username+1)
                .where(users.name.eq(username))
                .execute();
    }
    @Override
    public List<UserDTO> findAllUserDTOs(){
        return jpaQueryFactory.select(Projections.constructor(UserDTO.class,
                        users.id,
                        users.name,
                        users.email
                        ))
                .from(users)
                .fetch();
    }
}
