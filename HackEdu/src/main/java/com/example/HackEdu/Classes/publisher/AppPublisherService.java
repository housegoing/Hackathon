//package com.example.HackEdu.Classes.publisher;
//
//import com.example.HackEdu.Classes.registration.token.ConfirmationToken;
//import com.example.HackEdu.Classes.registration.token.ConfirmationTokenService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Service
//@AllArgsConstructor
//public class AppPublisherService implements UserDetailsService {
//    private final AppPublisherRepository appPublisherRepository;
//    private final static String USER_NOT_FOUND_MSG =
//            "user with email %s not found";
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final ConfirmationTokenService confirmationTokenService;
//
//    @Override
//    public UserDetails loadUserByUsername(String s)
//            throws UsernameNotFoundException {
//        return appPublisherRepository.findByEmail(s)
//            .orElseThrow(() ->
//                    new UsernameNotFoundException("NotFound"));
//    }
//
//    public String signUpUser(Publisher publisher){
//        boolean userExists = appPublisherRepository.findByEmail(publisher.getEmail())
//                .isPresent();
//
//        if(userExists){
//            throw new IllegalStateException("Email taken");
//        }
//        String encodedPassword = bCryptPasswordEncoder.encode(publisher.getPassword());
//        publisher.setPassword(encodedPassword);
//
//        appPublisherRepository.save(publisher);
//
//        String token = UUID.randomUUID().toString();
//
//        ConfirmationToken confirmationToken = new ConfirmationToken(
//                token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(15),
//                publisher
//        );
//
//        confirmationTokenService.saveConfirmationToken(
//                confirmationToken);
//
//        return token;
//    }
//}
