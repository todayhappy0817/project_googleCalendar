package com.project1.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorResponseStatus {
    Fail("S003", HttpStatus.BAD_REQUEST, "one or more required API parameters");
    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;
}
