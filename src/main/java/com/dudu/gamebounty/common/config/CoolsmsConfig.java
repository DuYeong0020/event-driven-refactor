package com.dudu.gamebounty.common.config;

import com.dudu.gamebounty.common.props.CoolsmsProperties;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoolsmsConfig {

    private static final String DOMAIN = "https://api.coolsms.co.kr";

    @Bean
    public DefaultMessageService defaultMessageService(CoolsmsProperties coolsmsProperties) {
        return NurigoApp.INSTANCE.initialize(coolsmsProperties.getKey(), coolsmsProperties.getSecret(), DOMAIN);
    }
}