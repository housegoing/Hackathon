package com.example.HackEdu.Classes.history;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearningHistoryRepository extends JpaRepository<LearningHistory, Long> {
    Optional<LearningHistory>
        findLearningHistoryByArticleAndUser(Article article, User user);
    Optional<LearningHistory>
        findLearningHistoryByVideoAndUser(Video video, User user);
    List<LearningHistory>
        findLearningHistoryByUser(User user);
}
