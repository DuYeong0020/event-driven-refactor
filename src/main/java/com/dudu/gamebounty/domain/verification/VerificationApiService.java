package com.dudu.gamebounty.domain.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationApiService {

    private final VerificationCodeService verificationCodeService;

    public void sendCode(String recipient, VerificationType verificationType) {
        // todo - 하루 5회가 넘었는지 체크할것
        verificationCodeService.createAndSaveCode(recipient, verificationType);
        // todo - send verification Code;
    }


}
