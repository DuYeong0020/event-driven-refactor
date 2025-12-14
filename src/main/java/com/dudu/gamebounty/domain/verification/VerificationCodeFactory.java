package com.dudu.gamebounty.domain.verification;

public class VerificationCodeFactory {

    public static VerificationCodeEntity of(String recipient, String code, VerificationType type) {
        return new VerificationCodeEntity(recipient, code, type);
    }
}
