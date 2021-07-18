package com.example.HackEdu;
import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.article.ArticleRepository;
import com.example.HackEdu.Classes.article.ArticleService;
import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.course.CourseService;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.user.UserService;
import com.example.HackEdu.Twilio.Service;
import com.example.HackEdu.Twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HackEduController {

    private final Service service;

    private UserService userService;

    private CourseService courseService;

    private ArticleService articleService;

    private final ArticleRepository articleRepository;

    @Autowired
    public HackEduController(Service service, UserService userService, CourseService courseService, ArticleService articleService, ArticleRepository articleRepository) {
        this.service = service;
        this.userService = userService;
        this.courseService = courseService;
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }

    @RequestMapping("/smsSender")
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @RequestMapping("/sms")
    @ResponseBody
    public String smsDispatch(@RequestParam("From") String from, @RequestParam("Body") String body){
        Course course = new Course();
        course.setTopic("Art");
        Article article = new Article();
        article.setName("Book");
        article.setContent("This is a book");
        articleRepository.save(article);

        String phoneNumber = from.substring(1);
        userService.addNewUser(new User(phoneNumber));

        String[] inputMsg = body.toLowerCase().split(" ");

        System.out.println(inputMsg);

        String responseMsg = "";

        String help = '\n' + "Welcome to HackEdu!" + '\n' +
                "Use 'list topic' to explore your interested topics." + '\n' +
                "Use 'list topicIndex course' to explore courses in your interested topic." + '\n';

        String error = '\n' + "Invalid input! Type 'e-help' to get instructions.";

        switch(inputMsg[0]){
            case "e-help":
                responseMsg = help;
                break;
            case "list":
                System.out.println(inputMsg[1]);
                if(inputMsg[1].equals("topic")){
                    responseMsg = "Topics:" + '\n' + "Index---Topic" + '\n';
                    int count = 1;
                    for(Course c: courseService.getCourse()){
                        responseMsg = responseMsg + "  #" + String.valueOf(count) + "---" + c.getTopic() + '\n';
                        count = count + 1;
                    }
                }else{
                    try{
                        int topicIndex = Integer.parseInt(inputMsg[1].substring(1));

                        if(inputMsg[2].equals("course") && topicIndex > 0){
                            //todo list all courses in that topic
                            responseMsg = "You are viewing Topic " + courseService.getCourse().get(topicIndex-1).getTopic() +":" + '\n' +
                                    "Index --- Type --- Course" + '\n';
                            int count = 1;
                            for(Article a: articleService.getArticalByTopic(courseService.getCourse().get(topicIndex-1).getTopic())){
                                responseMsg = responseMsg + "  #" + String.valueOf(count) + "  ---  "+ "Article  ---  " + a.getName() + '\n';
                                count = count + 1;
                            }

                        }else{
                            responseMsg = error;
                        }
                    }
                    catch (NumberFormatException ex){
                        responseMsg = error;
                    }
                }
                break;
            case "start":
                try {
                    int index = Integer.parseInt(inputMsg[1]);

                } catch (NumberFormatException nfe) {
                    responseMsg = "The index is not valid";
                }
                break;
            default:
                responseMsg = error;
                break;
        }
        return responseMsg;
    }

}
