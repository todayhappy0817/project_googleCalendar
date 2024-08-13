package com.project1.project1.utils.restResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

@Getter
@AllArgsConstructor
public enum ErrorResponseStatus {
    Fail("F001", HttpStatus.BAD_REQUEST, "one or more required API parameters"), //401에러
    NotFound("F004",HttpStatus.NOT_FOUND, "page Not Found"),;

    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;

}
