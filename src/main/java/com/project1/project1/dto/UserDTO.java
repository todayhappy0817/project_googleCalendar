package com.project1.project1.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    public enum Status{
        DEFAULT, BAN, STOP
    }
    private Long id;
    @NotNull(message = "이름은 Null 일 수 없습니다!")
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Status status;

//    @QueryProjection
    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
