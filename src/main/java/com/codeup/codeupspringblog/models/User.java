package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="blogUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=255, nullable = false)
    private String username;

    @Column(length=255, nullable = false)
    private String email;

    @Column(length=255, nullable = false)
    private String password;

//    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
//    @ToString.Exclude
//    private List<Post> post;

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public static void main(String[] args) {
    }

}
