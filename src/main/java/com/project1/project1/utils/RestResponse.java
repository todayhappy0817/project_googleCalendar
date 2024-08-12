package com.project1.project1.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestResponse<T>{
    private int code;
    private String message;
    private T data;

}
