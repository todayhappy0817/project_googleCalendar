package com.project1.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class ErrorResponseDto<T> extends ResponseDto<T>{

    private ErrorResponseDto(ErrorResponseStatus status){
        super(status.getCode(), status.getHttpStatus(), status.getMoreInformation());
    }
    public static <T> ErrorResponseDto<T> from(ErrorResponseStatus status){
        return new ErrorResponseDto<T>(status);
    }
}

@Getter
@AllArgsConstructor
public enum ErrorResponseStatus {
    Fail("S003", HttpStatus.BAD_REQUEST, "one or more required API parameters");
    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;
}

public class RestResponseUtil{
    public static ResponseEntity<ErrorResponseDto<Object>> Fail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.from(ErrorResponseStatus.Fail));
    }
}

public abstract class ResponseDto<T> {
    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;
}