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
    @Column(updatable = false, name="users_id")
    private Long id;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    private List<LearningHistory> learningHistoryList;

    public User(Long id, String phoneNumber, String firstName, String lastName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.learningHistoryList = null;
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.learningHistoryList = null;
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

    public void addLearningHistory(LearningHistory learningHistory) {
        this.learningHistoryList.add(learningHistory);
    }

    //    public void registerNewUser()
}
