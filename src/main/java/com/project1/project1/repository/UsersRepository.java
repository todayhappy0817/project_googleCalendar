package com.project1.project1.repository;


import com.project1.project1.domain.Users;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Primary
public interface UsersRepository extends JpaRepository<Users, Long>, UserCustomRepository{
    @Query("SELECT u from Users u where u.id = :username")
    List<Users> findOrdersByUsername(@Param("username") String username);

    @Query("SELECT u from Users u")
    List<Users> findUser();

    Users findByName(String username);
}
