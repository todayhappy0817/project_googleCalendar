package com.project1.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ResponseType<T> {
    private int code;
    private String message;
    private T data;

}
