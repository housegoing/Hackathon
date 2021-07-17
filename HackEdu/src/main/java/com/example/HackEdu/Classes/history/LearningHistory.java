package com.example.HackEdu.Classes.history;

import com.example.HackEdu.Classes.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "learning_history")
public class LearningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateAccess;
    private String contentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;

    public LearningHistory(LocalDate dateAccess, String contentId, User user) {
        this.dateAccess = dateAccess;
        this.contentId = contentId;
        this.user = user;
    }

    public LearningHistory(Long id, LocalDate dateAccess, String contentId, User user) {
        this.id = id;
        this.dateAccess = dateAccess;
        this.contentId = contentId;
        this.user = user;
    }

    public LearningHistory() {
    }
}
