package com.example.HackEdu.Classes.video;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.publisher.Publisher;

import javax.persistence.*;

@Entity(name = "video")
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String link;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Video() {
    }

    public Video(Long id, String name, String link, Publisher publisher, Course course) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.publisher = publisher;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
