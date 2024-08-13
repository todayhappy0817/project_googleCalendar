package com.project1.project1.utils.restResponse;

import lombok.Getter;

@Getter
public class ErrorResponseDto<T> extends ResponseDto<T> {
    private final String moreInformation;

    private ErrorResponseDto(ErrorResponseStatus status) {
        super(status.getCode(), status.getHttpStatus());
        this.moreInformation = status.getMoreInformation();
    }

    public static <T> ErrorResponseDto<T> from(ErrorResponseStatus status){
        return new ErrorResponseDto<T>(status);
    }
}