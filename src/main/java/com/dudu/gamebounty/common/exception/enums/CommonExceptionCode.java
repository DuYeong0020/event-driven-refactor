package com.dudu.gamebounty.common.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonExceptionCode implements ExceptionCode {

    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON-4040", "exception.common.entityNotFound");

    private final HttpStatus status;
    private final String code;
    private final String messageKey;
}
