package com.example.HackEdu.Twilio;

import com.example.HackEdu.TwilioSMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {
    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSMSSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
