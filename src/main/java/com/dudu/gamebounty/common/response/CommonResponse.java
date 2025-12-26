package com.dudu.gamebounty.common.response;

import lombok.Builder;
import lombok.Getter;

import static com.dudu.gamebounty.common.response.CommonResponse.Result.FAIL;
import static com.dudu.gamebounty.common.response.CommonResponse.Result.SUCCESS;

@Getter
@Builder
public class CommonResponse<T> {

    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
                .result(SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> fail(String message, String errorCode) {
        return CommonResponse.<T>builder()
                .result(FAIL)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public enum Result {
        SUCCESS, FAIL
    }
}