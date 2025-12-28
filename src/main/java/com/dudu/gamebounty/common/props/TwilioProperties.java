package com.dudu.gamebounty.common.props;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "twilio")
public class TwilioProperties {

    private final String accountSid;
    private final String authToken;
    private final String phoneNumber;
}