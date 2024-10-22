package com.project1.project1.domain;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"brandId","categoryId","productId"})
public class ProductId implements Serializable {
      private Long brandId;
      private Long categoryId;
//      private Brand brandId;
//      private Category categoryId;
      private Long productId;
}
