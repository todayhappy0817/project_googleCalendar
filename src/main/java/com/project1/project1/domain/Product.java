package com.project1.project1.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @EmbeddedId
    private ProductId id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "brandId", referencedColumnName = "brandId", insertable = false, updatable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", insertable = false, updatable = false)
    private Category category;
}
