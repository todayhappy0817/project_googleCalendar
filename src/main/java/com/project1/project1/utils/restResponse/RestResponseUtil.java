package com.project1.project1.utils.restResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class RestResponseUtil{

    public static ResponseEntity<ResponseDto<?>> Fail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.from(ErrorResponseStatus.Fail));
    }

}
