package com.dudu.gamebounty.common.exception.exceptions;

import com.dudu.gamebounty.common.exception.enums.ExceptionCode;
import lombok.Getter;

@Getter
public class DefaultException extends RuntimeException {

    private final ExceptionCode exceptionCode;
    private final Object[] args;

    public DefaultException(ExceptionCode exceptionCode, Object ... args) {
        super(exceptionCode.getCode());
        this.exceptionCode = exceptionCode;
        this.args = args;
    }
}
