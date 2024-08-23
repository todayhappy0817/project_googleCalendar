package com.project1.project1.domain;


import com.project1.project1.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isWithDraw;
    private LocalDateTime createdAt;
}
