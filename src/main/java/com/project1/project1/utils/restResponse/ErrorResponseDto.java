package com.project1.project1.utils.restResponse;

import lombok.Getter;

@Getter
public class ErrorResponseDto<T> extends ResponseDto {
    private final String moreInformation;

    private ErrorResponseDto(ErrorResponseStatus status) {
        super(status.getCode(), status.getHttpStatus());
        this.moreInformation = status.getMoreInformation();
    }

    public static ErrorResponseDto<ResponseDto> from(ErrorResponseStatus status){
        return new ErrorResponseDto<ResponseDto>(status);
    }
}