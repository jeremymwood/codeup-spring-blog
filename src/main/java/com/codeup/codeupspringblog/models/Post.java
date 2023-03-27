package com.codeup.codeupspringblog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private long id;
    private String date;
    private String title;
    private String author;
    private String body;

}
