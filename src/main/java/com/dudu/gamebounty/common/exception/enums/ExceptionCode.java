package com.dudu.gamebounty.common.exception.enums;

import org.springframework.http.HttpStatus;

public interface ExceptionCode {
    HttpStatus getStatus();
    String getCode();
    String getMessageKey();
}
