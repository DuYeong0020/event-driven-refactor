package com.dudu.gamebounty.core.verification;


import com.dudu.gamebounty.domain.verification.VerificationCodeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeFindService {
    private final VerificationCodeRepository verificationCodeRepository;

    public VerificationCodeEntity findByRecipient(String recipient) {
        return verificationCodeRepository.findById(recipient)
                .orElseThrow(() -> new RuntimeException("Verification code not found for id: "));
    }
}
