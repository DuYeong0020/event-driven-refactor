package com.dudu.gamebounty.core.verification;

import com.dudu.gamebounty.domain.verification.VerificationCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface VerificationCodeRepository extends CrudRepository<VerificationCodeEntity, String> {
}
