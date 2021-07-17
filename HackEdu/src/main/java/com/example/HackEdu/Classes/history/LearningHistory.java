package com.example.HackEdu.Classes.history;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.video.Video;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "learning_history")
@Table()
public class LearningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateAccess;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}
