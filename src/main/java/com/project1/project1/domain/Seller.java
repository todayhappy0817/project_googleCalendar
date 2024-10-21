package com.project1.project1.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AttributeOverrides(
        @AttributeOverride(name = "id", column = @Column(name = "Seller_ID"))
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller extends BaseEntity{
    private String shopName;
}
