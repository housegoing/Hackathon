package com.example.HackEdu.Classes.history;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class LearningHistoryService {
    private final LearningHistoryRepository learningHistoryRepository;

    @Autowired
    public LearningHistoryService(LearningHistoryRepository learningHistoryRepository) {
        this.learningHistoryRepository = learningHistoryRepository;
    }

    public void updateLearningHistory(User user, Video video, Article article) {
        if(video == null) {
            Optional<LearningHistory> his = learningHistoryRepository.findLearningHistoryByArticleAndUser(article, user);
            if(his.isPresent()){
                his.get().setDateAccess(LocalDate.now());
            }else{
                LearningHistory newHis = new LearningHistory(LocalDate.now(), article, null, user);
                learningHistoryRepository.save(newHis);
            }
        }else{
            Optional<LearningHistory> his = learningHistoryRepository.findLearningHistoryByVideoAndUser(video, user);
            if(his.isPresent()){
                his.get().setDateAccess(LocalDate.now());
            }else{
                LearningHistory newHis = new LearningHistory(LocalDate.now(), null, video, user);
                learningHistoryRepository.save(newHis);
            }
        }
    }
}
