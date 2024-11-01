package com.project1.project1.domain;

//import com.querydsl.core.types.EntityPath;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@Table(name ="Users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "orders")
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @BatchSize(size = 3)
    private List<Orders> orders = new ArrayList<>();
}
