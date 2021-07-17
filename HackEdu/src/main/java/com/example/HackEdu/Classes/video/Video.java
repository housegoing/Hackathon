package com.example.HackEdu.Classes.video;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.publisher.Publisher;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Video {
    private String id;
    private String name;
    private String link;
    private Publisher publisher;

    @ManyToOne
    @JoinColumn
    private Course course;
}
