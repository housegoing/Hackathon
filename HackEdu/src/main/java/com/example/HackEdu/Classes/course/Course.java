package com.example.HackEdu.Classes.course;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.video.Video;

import javax.persistence.*;
import java.util.List;

public class Course {

    @Id
    @GeneratedValue()
    private String id;
    private String courseName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    private List<Video> videoList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Article> articleList;
}
