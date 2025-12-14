package com.dudu.gamebounty.core.verification;

import com.dudu.gamebounty.domain.verification.VerificationCodeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VerificationCodeCommandService {

    private final VerificationCodeRepository verificationCodeRepository;

    public VerificationCodeEntity save(VerificationCodeEntity verificationCodeEntity) {
        return verificationCodeRepository.save(verificationCodeEntity);
    }
}
