//package com.example.HackEdu.Classes.registration;
//
//import com.example.HackEdu.Classes.publisher.AppPublisherRole;
//import com.example.HackEdu.Classes.publisher.AppPublisherService;
//import com.example.HackEdu.Classes.publisher.Publisher;
//import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@AllArgsConstructor
//public class RegistrationService {
//    private final EmailValidator emailValidator;
//    private final AppPublisherService appPublisherService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public String register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.test(request.getEmail());
//        if(!isValidEmail){
//            throw new IllegalStateException("email not valid");
//        }
//        return appPublisherService.signUpUser(
//                new Publisher(
//                        request.getFirstName(),
//                        request.getLastName(),
//                        request.getEmail(),
//                        request.getPassword(),
//                        AppPublisherRole.PUBLISHER
//                )
//        );
//    }
//
//    @Transactional
//    public String confirmToken(String token) {
//        return "confirm";
//    }
//}
