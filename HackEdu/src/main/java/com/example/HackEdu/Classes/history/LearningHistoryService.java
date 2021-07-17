package com.example.HackEdu.Classes.history;

import com.example.HackEdu.Classes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningHistoryService {
    private final LearningHistoryRepository learningHistoryRepository;

    @Autowired
    public LearningHistoryService(LearningHistoryRepository learningHistoryRepository) {
        this.learningHistoryRepository = learningHistoryRepository;
    }
}
