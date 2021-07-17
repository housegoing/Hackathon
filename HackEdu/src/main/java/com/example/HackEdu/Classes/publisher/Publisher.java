package com.example.HackEdu.Classes.publisher;

import com.example.HackEdu.Classes.article.Article;
import com.example.HackEdu.Classes.video.Video;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Publisher {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false)
    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "publisher")
    private List<Article> articleList;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "publisher")
    private List<Video> videoList;
    public Publisher() {
    }

    public Publisher(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
