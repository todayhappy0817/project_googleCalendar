package com.project1.project1.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@IdClass(ProductId.class)
public class Product {
    @Id
    private Long productId;  // 1000: 제품ID
    @Id
    private Long brandId;
    @Id
    private Long categoryId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "brandId", referencedColumnName = "brandId", insertable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", insertable = false, updatable = false)
    private Category category;
}
