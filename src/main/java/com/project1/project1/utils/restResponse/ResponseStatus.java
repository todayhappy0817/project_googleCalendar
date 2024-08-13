package com.project1.project1.utils.restResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS("S001",HttpStatus.OK);

    private final String code;
    private final HttpStatus httpStatus;
}
