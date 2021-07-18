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
    @JoinColumn(name = "article_id", referencedColumnName = "ID")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "video_id", referencedColumnName = "ID")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    public LearningHistory() {
    }

    public LearningHistory(LocalDate dateAccess, Article article, Video video, User user) {
        this.dateAccess = dateAccess;
        this.article = article;
        this.video = video;
        this.user = user;
    }

    public LearningHistory(Long id, LocalDate dateAccess, Article article, Video video, User user) {
        this.id = id;
        this.dateAccess = dateAccess;
        this.article = article;
        this.video = video;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAccess() {
        return dateAccess;
    }

    public void setDateAccess(LocalDate dateAccess) {
        this.dateAccess = dateAccess;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
