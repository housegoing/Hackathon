package com.example.HackEdu.Classes.user;

import com.example.HackEdu.Classes.history.LearningHistory;
import com.example.HackEdu.Classes.history.LearningHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final LearningHistoryRepository learningHistoryRepository;

    @Autowired
    public UserService(UserRepository userRepository, LearningHistoryRepository learningHistoryRepository){
        this.userRepository = userRepository;
        this.learningHistoryRepository = learningHistoryRepository;
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByPhoneNumber(user.getPhoneNumber());
        if (!userOptional.isPresent()) {
            userRepository.save(user);
        }
    }

    public List<LearningHistory> getLearningHistory (User user) {
        List<LearningHistory> learningHistoryList = learningHistoryRepository.findLearningHistoryByUser(user);
        return learningHistoryList;
    }
}
