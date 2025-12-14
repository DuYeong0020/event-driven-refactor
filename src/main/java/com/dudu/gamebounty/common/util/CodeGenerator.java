package com.dudu.gamebounty.common.util;

import java.security.SecureRandom;

public class CodeGenerator {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateNumericCode() {
        int code = SECURE_RANDOM.nextInt(1_000_000);
        return String.format("%06d", code);
    }
}
