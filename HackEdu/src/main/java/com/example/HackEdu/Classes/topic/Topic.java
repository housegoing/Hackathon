package com.example.HackEdu.Classes.topic;

import com.example.HackEdu.Classes.course.Course;

import java.util.List;

public class Topic {

    private Long ID;
    private String topicName;
    private List<Course> courseList;

    public Topic(String topicName, List<Course> courseList) {
        this.topicName = topicName;
        this.courseList = courseList;
    }

    public Topic(Long ID, String topicName, List<Course> courseList) {
        this.ID = ID;
        this.topicName = topicName;
        this.courseList = courseList;
    }

    public Long getID() {
        return ID;
    }

    public String getTopicName() {
        return topicName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
