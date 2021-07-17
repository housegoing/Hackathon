package com.example.HackEdu.Classes.article;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.publisher.Publisher;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue()
    private String id;
    private String name;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
}
