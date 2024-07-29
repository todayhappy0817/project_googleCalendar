package com.project1.project1.dto;

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
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;
    private boolean isWithDraw;
    private Status status;
}
