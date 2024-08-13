package com.project1.project1.utils;


import com.project1.project1.dto.ErrorResponseDto;
import com.project1.project1.dto.ErrorResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class RestResponseUtil{
    public static ResponseEntity<ErrorResponseDto<Object>> Fail(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDto.from(ErrorResponseStatus.Fail));
    }
}
