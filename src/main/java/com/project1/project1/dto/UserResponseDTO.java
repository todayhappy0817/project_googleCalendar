package com.project1.project1.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isWithDraw;
    private LocalDateTime createdAt;
}
