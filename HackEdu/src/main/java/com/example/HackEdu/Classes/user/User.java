package com.example.HackEdu.Classes.user;

import com.example.HackEdu.Classes.history.LearningHistory;

import javax.persistence.*;
import java.util.List;

@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "users_phone_unique", columnNames = "phone_number")
})
@Entity(name = "Users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "his_id")
    private LearningHistory learningHistory;

    public User(Long id, String phoneNumber, String firstName, String lastName, String state, LearningHistory learningHistory) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.learningHistory = learningHistory;
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LearningHistory getLearningHistory() {
        return learningHistory;
    }

    public void setLearningHistory(LearningHistory learningHistory) {
        this.learningHistory = learningHistory;
    }

    //    public void registerNewUser()
}
