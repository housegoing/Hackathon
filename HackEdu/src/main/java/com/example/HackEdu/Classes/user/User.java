package com.example.HackEdu.Classes.user;

import javax.persistence.*;

@Entity(name = "User")
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
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String state;

    public User(String phoneNumber, String firstName, String lastName, String state) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }

    public User(Long id, String phoneNumber, String firstName, String lastName, String state) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
    }

    public User() {

    }

//    public void registerNewUser()
}
