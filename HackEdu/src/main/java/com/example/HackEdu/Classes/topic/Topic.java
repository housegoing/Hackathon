package com.example.HackEdu.Classes.topic;

import com.example.HackEdu.Classes.course.Course;

import java.util.List;

public class Topic {

    private String ID;
    private String topicName;
    private List<Course> courseList;

    public Topic(String topicName, List<Course> courseList) {
        this.topicName = topicName;
        this.courseList = courseList;
    }

    public Topic(String ID, String topicName, List<Course> courseList) {
        this.ID = ID;
        this.topicName = topicName;
        this.courseList = courseList;
    }

    public String getID() {
        return ID;
    }

    public String getTopicName() {
        return topicName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
