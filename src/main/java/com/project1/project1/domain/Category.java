package com.project1.project1.domain;

import jakarta.persistence.*;

@Entity
@IdClass(CategoryId.class)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
