package com.dudu.gamebounty.core.sms;

import com.dudu.gamebounty.common.props.TwilioProperties;
import com.dudu.gamebounty.domain.sms.SmsBalance;
import com.dudu.gamebounty.domain.sms.SmsClient;
import com.twilio.rest.api.v2010.account.Balance;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwilioSmsClient implements SmsClient {
    private final TwilioProperties twilioProperties;

    @Override
    public void send(String to, String text) {
        try {
            Message.creator(new PhoneNumber(to), new PhoneNumber(twilioProperties.getPhoneNumber()), text)
                    .create();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public SmsBalance getBalance() {
        try {
            Balance balance = Balance.fetcher().fetch();
            return SmsBalance.from(balance);
        } catch (Exception e) {
            return SmsBalance.empty();
        }
    }
}