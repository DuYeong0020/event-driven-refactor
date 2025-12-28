package com.dudu.gamebounty.domain.sms;

import lombok.Builder;
import lombok.Getter;
import net.nurigo.sdk.message.model.Balance;

import java.math.BigDecimal;

@Getter
public class SmsBalance {

    private final BigDecimal amount;

    @Builder
    public SmsBalance(BigDecimal amount) {
        this.amount = amount;
    }

    public static SmsBalance from(Balance balance) {
        return SmsBalance.builder()
                .amount(balance.getBalance() != null ? BigDecimal.valueOf(balance.getBalance()) : BigDecimal.ZERO)
                .build();
    }

    public static SmsBalance from(com.twilio.rest.api.v2010.account.Balance balance) {
        return SmsBalance.builder()
                .amount(balance.getBalance() != null ? new BigDecimal(balance.getBalance()) : BigDecimal.ZERO)
                .build();
    }

    public static SmsBalance empty() {
        return SmsBalance.builder()
                .amount(null)
                .build();
    }

}
