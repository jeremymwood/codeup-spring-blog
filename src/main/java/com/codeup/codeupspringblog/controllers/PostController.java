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

        posts.add(new Post(1, "02.25.2023","Laboriosam 1", "Richard Carnation", "Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?"));

        posts.add(new Post(2, "03.05.2023", "Necessitatibus 2", "Richard Carnation", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequatur ea ex officia? Aliquam aut beatae incidunt iste laboriosam neque, quibusdam!"));

        posts.add(new Post(3, "03.26.2023", "Inventores 3", "Todd Reynolds", "Aperiam architecto asperiores consectetur consequuntur cumque deleniti distinctio dolor dolore dolorem eius eligendi est exercitationem fuga fugiat id itaque minus modi nam neque nisi non omnis placeat quia quidem quod ratione recusandae reprehenderit repudiandae similique sint sunt temporibus, veritatis voluptas?"));

        posts.add(new Post(4, "03.27.2023", "Laudantium 4", "Debra Smith", "A accusantium ad animi asperiores, consectetur culpa dolor dolores, ducimus enim eos esse est fuga ipsum itaque iusto magni maxime minus modi molestiae quasi quia quibusdam quis quo, sapiente veniam?"));

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
