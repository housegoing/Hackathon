package com.example.HackEdu.Classes.user;

import com.example.HackEdu.Classes.history.LearningHistory;
import com.example.HackEdu.Classes.history.LearningHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByPhoneNumber(user.getPhoneNumber());
        if (!userOptional.isPresent()) {
            userRepository.save(user);
        }
    }
}
