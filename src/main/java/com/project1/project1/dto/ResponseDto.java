package com.project1.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class ResponseDto<T> {
    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;
}
