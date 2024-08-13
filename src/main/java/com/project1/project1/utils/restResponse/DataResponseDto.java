package com.project1.project1.utils.restResponse;

import lombok.Getter;

@Getter
public class DataResponseDto<T> extends ResponseDto<T>{
    private final T data;

    private DataResponseDto(T data){
        super(ResponseStatus.SUCCESS.getCode(),ResponseStatus.SUCCESS.getHttpStatus());
        this.data = data;
    }
    public static <T> DataResponseDto<T> success(T data){
        return new DataResponseDto<T>(data);
    }
}
