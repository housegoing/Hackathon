package com.example.HackEdu.Classes.video;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.publisher.Publisher;

import javax.persistence.*;

@Entity(name = "video")
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue()
    private String id;
    private String name;
    private String link;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
}
