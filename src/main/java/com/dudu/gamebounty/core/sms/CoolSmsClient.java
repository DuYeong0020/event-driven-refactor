package com.dudu.gamebounty.core.sms;

import com.dudu.gamebounty.common.props.CoolsmsProperties;
import com.dudu.gamebounty.domain.sms.SmsBalance;
import com.dudu.gamebounty.domain.sms.SmsClient;
import com.dudu.gamebounty.domain.sms.SmsVendor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Balance;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CoolSmsClient implements SmsClient {

    private final DefaultMessageService messageService;
    private final CoolsmsProperties coolsmsProperties;

    @Override
    public SmsVendor vendor() {
        return SmsVendor.COOLSMS;
    }

    @Override
    public void send(String to, String text) {
        Message message = new Message();
        message.setFrom(coolsmsProperties.getFrom());
        message.setTo(to);
        message.setText(text);

        try {
            messageService.send(message);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public SmsBalance getBalance() {
        try {
            Balance balance = messageService.getBalance();
            return SmsBalance.from(balance);
        } catch (Exception e) {
            return SmsBalance.empty();
        }
    }

}
