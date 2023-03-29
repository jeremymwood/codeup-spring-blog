package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length=10, nullable = false)
    private String date;

    @Column(length=1024, nullable = false)
    private String title;

    @Column(length=65535, nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
//    @Column(nullable = false)
    private User user;
}
