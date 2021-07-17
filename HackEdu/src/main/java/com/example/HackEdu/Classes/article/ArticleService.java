package com.example.HackEdu.Classes.article;

import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CourseRepository courseRepository) {
        this.articleRepository = articleRepository;
        this.courseRepository = courseRepository;
    }

    public List<Article> getArticalByTopic(String course) {
        Optional<Course> courseOptional = courseRepository.findCourseByTopic(course);
        if(!courseOptional.isPresent()){
            throw new IllegalStateException("Course not exist");
        }
        return articleRepository.findArticleByCourse(courseOptional);
    }
}
