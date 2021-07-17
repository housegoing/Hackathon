package com.example.HackEdu;
import com.example.HackEdu.Classes.publisher.Publisher;
import com.example.HackEdu.Classes.publisher.PublisherService;
import com.example.HackEdu.Twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HackEduController {

    private final Service service;
    private final PublisherService publisherService;

    @Autowired
    public HackEduController(Service service, PublisherService publisherService) {
        this.service = service;
        this.publisherService = publisherService;
    }

    @RequestMapping("/smsSender")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }

    @RequestMapping("/sms")
    @ResponseBody
    public String smsDispatch(@RequestParam("From") String from, @RequestParam("Body") String body){
        return body;
    }

    @PostMapping("/addPublisher")
    public void addPublisher(@RequestBody Publisher publisher) {
        publisherService.addPublisher(publisher);
        System.out.println("Added user");
    }
}
