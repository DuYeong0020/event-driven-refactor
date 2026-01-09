package com.dudu.gamebounty.domain.sms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CountryCode {
    KR("+82"),
    CN("+86"),
    US("+1"),
    JP("+81");

    private final String prefix;

    public static CountryCode from(String phoneNumber) {
        String normalized = phoneNumber.replaceAll("\\s", "");

        for (CountryCode code : values()) {
            if (!code.prefix.isEmpty() && normalized.startsWith(code.prefix)) {
                return code;
            }
        }
        return null;
    }
}