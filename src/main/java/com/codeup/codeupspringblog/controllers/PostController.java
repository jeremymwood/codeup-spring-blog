package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String all(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "Post 1", "Post 1 body"));
        posts.add(new Post(2, "Post 2", "Post 2 body"));

        model.addAttribute("posts", posts);

        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, String title, String body) {
        return "view an individual post from id: " + id + "\n" + title + "\n" + body;
    }

    @GetMapping("/posts/create")
    public String createPostPage() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String postCreatePostPage() {
        return "create a new post";
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
