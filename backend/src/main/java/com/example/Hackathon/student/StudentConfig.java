package com.example.Hackathon.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                "Mariam",
                "mariam@gmail.com",
                LocalDate.of(2000, Month.APRIL, 4)
            );

            Student chris = new Student(
                    "Chris",
                    "chris@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 4)
            );

            repository.saveAll(
                    List.of(mariam, chris)
            );
        };
    }
}
