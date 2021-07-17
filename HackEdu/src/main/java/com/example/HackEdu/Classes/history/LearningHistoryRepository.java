package com.example.HackEdu.Classes.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningHistoryRepository extends JpaRepository<LearningHistory, Long> {

}
