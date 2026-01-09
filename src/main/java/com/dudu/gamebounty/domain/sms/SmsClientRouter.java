package com.dudu.gamebounty.domain.sms;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SmsClientRouter {

    private final Map<SmsVendor, SmsClient> smsClients;

    public SmsClientRouter(List<SmsClient> smsClients) {
        this.smsClients = smsClients.stream()
                .collect(Collectors.toMap(SmsClient::vendor, Function.identity()));
    }

    public SmsClient route(String phoneNumber) {
        CountryCode code = CountryCode.from(phoneNumber);
        return smsClients.get(resolveVendor(code));
    }

    private SmsVendor resolveVendor(CountryCode code) {
        return switch (code) {
            case KR, CN -> SmsVendor.COOLSMS;
            case US, JP -> SmsVendor.TWILIO;
            case null -> throw new IllegalArgumentException("지원하지 않는 국가 코드");
        };
    }
}
