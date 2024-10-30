package com.project1.project1.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    public enum CategoryType {
        Earphone, Phone, PC
    }
}
