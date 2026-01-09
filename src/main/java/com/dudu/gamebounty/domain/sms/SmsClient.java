package com.dudu.gamebounty.domain.sms;


public interface SmsClient {

    SmsVendor vendor();

    void send(String to, String text);

    SmsBalance getBalance();
}