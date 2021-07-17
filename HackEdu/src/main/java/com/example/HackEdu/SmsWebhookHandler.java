package com.example.HackEdu;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiML;
import com.twilio.twiml.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class SmsWebhookHandler {

    private final Map<String, Integer> messageCounts = new ConcurrentHashMap<>();

    @PostMapping(value = "/receive-sms", produces = "application/xml")
    @ResponseBody
    public String handleSmsWebhook(@RequestParam("From") String from, @RequestParam("Body") String body) {
        int msgCount = messageCounts.compute(from, (k,v)->(v == null) ? 1 : v+1);
        String plural = (msgCount > 1) ? "messages" : "message";
        String message = String.format("Hello from Twilio, you sent %d %s, and this one said '%s'", msgCount, plural, body);
        return new MessagingResponse.Builder()
                .message(new Message.Builder(message).build())
                .build().toXml();
    }
}
