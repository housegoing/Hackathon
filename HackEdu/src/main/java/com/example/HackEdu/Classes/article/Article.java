package com.example.HackEdu.Classes.article;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.publisher.Publisher;

import javax.persistence.*;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "ID")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "ID")
    private Course course;

    public Article() {
    }

    public Article(Long id, String name, String content, Publisher publisher, Course course) {
        this.id = id;
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
