package com.example.HackEdu.Classes.video;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository, CourseRepository courseRepository) {
        this.videoRepository = videoRepository;
        this.courseRepository = courseRepository;
    }

    public List<Video> getVideoByTopic(String topic) {
        Optional<Course> optionalCourse = courseRepository.findCourseByTopic(topic);
        if(!optionalCourse.isPresent()){
            throw new IllegalStateException("Topic not exist");
        }
        return videoRepository.findAllByCourse(optionalCourse.get());
    }

}
