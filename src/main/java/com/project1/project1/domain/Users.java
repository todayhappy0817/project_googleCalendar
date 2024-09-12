package com.project1.project1.domain;

//import com.querydsl.core.types.EntityPath;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString(exclude = "orders")
@Table(name ="Users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "users")
    private List<Orders> orders = new ArrayList<>();
}
