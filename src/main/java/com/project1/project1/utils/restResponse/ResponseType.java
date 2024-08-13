package com.project1.project1.utils.restResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseType<T> {
    private int code;
    private String message;
    private T data;

}
