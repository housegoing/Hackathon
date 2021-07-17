package com.example.HackEdu;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {
    private final TwilioSMSSender twilioSMSSender;

    @Autowired
    public Service(TwilioSMSSender twilioSMSSender) {
        this.twilioSMSSender = twilioSMSSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        twilioSMSSender.sendSms(smsRequest);
    }
}
