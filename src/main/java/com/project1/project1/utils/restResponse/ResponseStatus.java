package com.project1.project1.utils.restResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS(200,"");
    private final int status;
    private final String message;
}
