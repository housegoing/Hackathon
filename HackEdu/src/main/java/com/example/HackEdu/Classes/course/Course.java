package com.example.HackEdu.Classes.course;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.video.Video;

import javax.persistence.*;
import java.util.List;

@Entity(name = "course")
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "topic", unique = true)
    private String topic;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "course")
    private List<Video> videoList;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "course")
    private List<Article> articleList;

    public Course() {
    }

    public Course(Long id, String topic, List<Video> videoList, List<Article> articleList) {
        this.id = id;
        this.topic = topic;
        this.videoList = videoList;
        this.articleList = articleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
