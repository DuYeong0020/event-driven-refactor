package com.dudu.gamebounty.domain.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsClientRouter smsClientRouter;

    public void send(String phoneNumber, String message) {
        SmsClient smsClient = smsClientRouter.route(phoneNumber);
        smsClient.send(phoneNumber, message);
    }
}
