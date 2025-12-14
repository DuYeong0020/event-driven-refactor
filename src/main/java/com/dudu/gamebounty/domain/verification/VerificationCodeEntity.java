package com.dudu.gamebounty.domain.verification;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class VerificationCodeEntity {

    private String recipient;
    private String code;

    private VerificationType verificationType;
    private VerificationStatus verificationStatus;

    private int attemptCount;
    private int resendCount;

    private LocalDateTime verifiedAt;

    public VerificationCodeEntity(String recipient, String code, VerificationType verificationType) {
        this.recipient = recipient;
        this.code = code;
        this.verificationType = verificationType;
        this.verificationStatus = VerificationStatus.PENDING;
        this.attemptCount = 0;
        this.resendCount = 0;
    }

    public boolean verify(String code) {
        if (verificationStatus != VerificationStatus.PENDING) {
            return false;
        }
        increaseAttempt();

        if (!matches(code)) {
            return false;
        }
        verifySuccess();
        return true;
    }


    private void verifySuccess() {
        this.verificationStatus = VerificationStatus.VERIFIED;
        this.verifiedAt = LocalDateTime.now();
    }

    private void increaseAttempt() {
        attemptCount++;
    }

    private boolean matches(String code) {
        return this.code.equals(code);
    }
}
