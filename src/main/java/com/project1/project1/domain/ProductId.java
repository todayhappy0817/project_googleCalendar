package com.project1.project1.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"brandId","categoryId","productId"})
@Embeddable
public class ProductId implements Serializable {
      private Long brandId;
      private Long categoryId;
      private Long productId;
}
