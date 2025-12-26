package com.dudu.gamebounty.common.exception.advices;

import com.dudu.gamebounty.common.context.RequestContext;
import com.dudu.gamebounty.common.exception.enums.ExceptionCode;
import com.dudu.gamebounty.common.exception.exceptions.DefaultException;
import com.dudu.gamebounty.common.response.CommonResponse;
import com.dudu.gamebounty.core.common.enums.Language;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class DefaultExceptionAdvice {

    private final MessageSource messageSource;
    private final RequestContext requestContext;

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<?> handleDefaultException(DefaultException e) {
        ExceptionCode exceptionCode = e.getExceptionCode();
        Language language = requestContext.getLanguage();

        String message = messageSource.getMessage(exceptionCode.getMessageKey(), e.getArgs(), Locale.forLanguageTag(language.getKey()));
        log.error("[{}] code={}", e.getClass().getSimpleName(), exceptionCode.getCode());

        return ResponseEntity.status(exceptionCode.getStatus())
                        .body(CommonResponse.fail(message, exceptionCode.getCode()));
    }
}