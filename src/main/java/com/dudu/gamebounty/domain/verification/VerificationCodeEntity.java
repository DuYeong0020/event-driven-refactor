package com.dudu.gamebounty.domain.verification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

import static com.dudu.gamebounty.common.constant.VerificationCodeConstants.CODE_VALID_SECONDS;
import static com.dudu.gamebounty.common.constant.VerificationCodeConstants.MAX_ATTEMPT_COUNT;

@Getter
@RedisHash(value = "verificationCode", timeToLive = CODE_VALID_SECONDS)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class VerificationCodeEntity {

    @Id
    private String recipient;
    private String code;

    private VerificationType verificationType;
    private VerificationStatus verificationStatus;
    private LocalDateTime verifiedAt;

    public VerificationCodeEntity(String recipient, String code, VerificationType verificationType) {
        this.recipient = recipient;
        this.code = code;
        this.verificationType = verificationType;
        this.verificationStatus = VerificationStatus.PENDING;
    }

    public boolean verify(String code) {
        if (verificationStatus != VerificationStatus.PENDING) {
            return false;
        }

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


    private boolean matches(String code) {
        return this.code.equals(code);
    }
}
