package com.project1.project1.utils.restResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private final String code;
    private final HttpStatus httpStatus;
    private final String moreInformation;
}
