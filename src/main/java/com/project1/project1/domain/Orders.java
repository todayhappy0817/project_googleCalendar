package com.project1.project1.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderData;

    @ManyToOne
    @JoinColumn(name = "Users_ID")
    private Users users;
}
