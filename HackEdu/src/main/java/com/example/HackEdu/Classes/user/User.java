package com.example.HackEdu.Classes.user;

import javax.persistence.*;

@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(name = "users_phone_unique", columnNames = "phoneNumber")
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
    @Column(nullable = false)
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
