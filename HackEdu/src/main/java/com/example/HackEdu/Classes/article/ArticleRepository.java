package com.example.HackEdu.Classes.article;

import com.example.HackEdu.Classes.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticleByCourse(Course course);
}
