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
    private String id;
    private String topic;

    @OneToMany(mappedBy = "course")
    private List<Video> videoList;

    @OneToMany(mappedBy = "course")
    private List<Article> articleList;
}
