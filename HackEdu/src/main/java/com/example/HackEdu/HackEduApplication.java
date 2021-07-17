package com.example.HackEdu;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.article.ArticleRepository;
import com.example.HackEdu.Classes.article.ArticleService;
import com.example.HackEdu.Classes.course.Course;
import com.example.HackEdu.Classes.course.CourseRepository;
import com.example.HackEdu.Classes.history.LearningHistory;
import com.example.HackEdu.Classes.history.LearningHistoryRepository;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HackEduApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HackEduApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LearningHistoryRepository learningHistoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CourseRepository courseRepository;


	@Override
	public void run(String... args) throws Exception {
		Course course = new Course();
		course.setTopic("Art");
		courseRepository.save(course);
		Article article = new Article();
		article.setName("Test");
		article.setCourse(course);
		articleRepository.save(article);

		List<Article> articleList = articleService.getArticalByTopic(course.getTopic());

		articleList.forEach((n)->System.out.print(n.getName()));
	}

}
