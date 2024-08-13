package com.project1.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS(200,"");
    private final int status;
    private final String message;
}
