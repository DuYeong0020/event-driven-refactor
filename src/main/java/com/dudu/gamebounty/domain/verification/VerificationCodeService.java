package com.dudu.gamebounty.domain.verification;

import com.dudu.gamebounty.common.util.CodeGenerator;
import com.dudu.gamebounty.core.verification.VerificationCodeCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationCodeService {

    private final VerificationCodeCommandService verificationCodeCommandService;

    public String createAndSaveCode(String recipient, VerificationType verificationType) {
        String code = CodeGenerator.generateNumericCode();
        verificationCodeCommandService.save(VerificationCodeFactory.of(recipient, code, verificationType));
        return code;
    }

}
