package com.dudu.gamebounty.core.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Locale;

@Getter
@RequiredArgsConstructor
public enum Language {
    KO("ko"),
    EN("en"),
    JA("ja");

    private final String key;

    private static final Language DEFAULT = KO;

    public static Language from(String rawLanguage) {
        if (!StringUtils.hasText(rawLanguage)) {
            return DEFAULT;
        }

        String normalized = normalize(rawLanguage);

        return Arrays.stream(values())
                .filter(language -> normalized.startsWith(language.name()))
                .findFirst()
                .orElse(DEFAULT);


    }

    private static String normalize(String rawLanguage) {
        return rawLanguage.split(",")[0].trim()
                .toUpperCase(Locale.ROOT);
    }

}
