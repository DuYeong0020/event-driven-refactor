package com.dudu.gamebounty.domain.sms;


public interface SmsClient {

    void send(String to, String text);

    SmsBalance getBalance();
}