package com.dudu.gamebounty.domain.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationApiService {

    private final VerificationCodeService verificationCodeService;

    public void sendCode(String recipient, VerificationType verificationType) {
        verificationCodeService.createAndSaveCode(recipient, verificationType);
        // todo - send verification Code;
    }


}
