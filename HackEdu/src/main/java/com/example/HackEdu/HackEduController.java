package com.example.HackEdu;
import com.example.HackEdu.Classes.publisher.AppPublisherService;
import com.example.HackEdu.Classes.publisher.Publisher;
import com.example.HackEdu.Twilio.Service;
import com.example.HackEdu.Twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class HackEduController {

    private final Service service;
    private final AppPublisherService appPublisherService;

    @Autowired
    public HackEduController(Service service, AppPublisherService appPublisherService) {
        this.service = service;
        this.appPublisherService = appPublisherService;
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
        appPublisherService.signUpUser(publisher);
        System.out.println("Added user");
    }
}
