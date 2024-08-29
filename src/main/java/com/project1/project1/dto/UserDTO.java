package com.project1.project1.dto;

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
    private int id;
    @NotNull(message = "이름은 Null 일 수 없습니다!")
    private String name;
    @NotEmpty(message = "이메일을 입력하세요")
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Status status;
}
