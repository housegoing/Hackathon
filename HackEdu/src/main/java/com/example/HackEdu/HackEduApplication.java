package com.example.HackEdu;

import com.example.HackEdu.Classes.history.LearningHistory;
import com.example.HackEdu.Classes.history.LearningHistoryRepository;
import com.example.HackEdu.Classes.user.User;
import com.example.HackEdu.Classes.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class HackEduApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HackEduApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LearningHistoryRepository learningHistoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setPhoneNumber("6112121212");

		LearningHistory learningHistory = new LearningHistory();
		learningHistory.setDateAccess(LocalDate.of(2021, 7, 17));
		learningHistory.setContentId("12586");

		learningHistory.setUser(user);
		user.setLearningHistory(learningHistory);

		userRepository.save(user);
	}

}
