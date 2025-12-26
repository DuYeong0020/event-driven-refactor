package com.dudu.gamebounty.common.exception.exceptions;

import com.dudu.gamebounty.common.exception.enums.CommonExceptionCode;

public class CommonException extends DefaultException {
    public CommonException(CommonExceptionCode commonExceptionCode, Object... args) {
        super(commonExceptionCode, args);
    }
}