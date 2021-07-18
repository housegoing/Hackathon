package com.example.HackEdu.Classes.video;

import com.example.HackEdu.Classes.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByCourse(Course course);
}
