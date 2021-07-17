package com.example.HackEdu;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.user.UserService;
import com.example.HackEdu.Twilio.SmsRequest;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HackEduController {

    private final Service service;

    private UserService userService;

    @Autowired
    public HackEduController(Service service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @RequestMapping("/smsSender")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }

    @RequestMapping("/sms")
    @ResponseBody
    public String smsDispatch(@RequestParam("From") String from, @RequestParam("Body") String body){
        String phoneNumber = from.substring(1);
        userService.addNewUser(new User(phoneNumber));

        String[] inputMsg = body.split(" ");

        System.out.println(inputMsg);

        String response = new String();

        String help = "Welcome to HackEdu!" + '\n' +
                "Use 'list topic' to explore your interested topics." + '\n' +
                "Use 'list topicIndex course' to explore courses in your interested topic." + '\n' +
                "Use 'list topicIndex courseIndex content' to explore contents in that specified course." + '\n';

        String error = "Invalid input! Type 'help' to get instructions.";

        switch(inputMsg[0]){
            case "help":
                response = help;
                break;
            case "list":
                if(inputMsg[1] == "topic"){
                    // todo list all topics
                    response = "Index-----Topic" + '\n';
                }else{
                    try{
                        int topicIndex = Integer.parseInt(inputMsg[1]);

                        if(inputMsg[2] == "course"){
                            //todo list all courses in that topic
                            response = "You are viewing Topic {NAME}:" + '\n' +
                                    "Index-----Course" + '\n';
                        }else{
                            response = error;
                        }
                    }
                    catch (NumberFormatException ex){
                        response = error;
                    }
                }
                break;
            default:
                response = error;
        }

        return response;
    }

}
