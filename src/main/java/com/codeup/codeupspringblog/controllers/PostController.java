package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {
    private final PostRepository postDao;

    @GetMapping
    public String all(Model model) {
//        List<Post> posts = new ArrayList<>();
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);

        List<Post> somePosts = postDao.findLikeName("a");
        System.out.println(somePosts);

        return "posts/show";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id) {
        Post post = postDao.findById(id).get();

        postDao.save(post);
        System.out.println(post);

        return "view an individual post: " + post;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost() {
        System.out.println("link working");
        Post post = new Post();
        post.setTitle("Laboriosam 1");
        post.setAuthor("Richard Carnation");
        post.setDate("02.25.2023");
        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");
        post.setTitle("Laboriosam 1");
        post.setAuthor("Richard Carnation");
        post.setDate("02.25.2023");
        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");
        post.setTitle("Laboriosam 1");
        post.setAuthor("Richard Carnation");
        post.setDate("02.25.2023");
        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");
        post.setTitle("Laboriosam 1");
        post.setAuthor("Richard Carnation");
        post.setDate("02.25.2023");
        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");

        System.out.println(post);
//        posts.add(new Post(2, "03.05.2023", "Necessitatibus 2", "Richard Carnation", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequatur ea ex officia? Aliquam aut beatae incidunt iste laboriosam neque, quibusdam!"));
//
//        posts.add(new Post(3, "03.26.2023", "Inventores 3", "Todd Reynolds", "Aperiam architecto asperiores consectetur consequuntur cumque deleniti distinctio dolor dolore dolorem eius eligendi est exercitationem fuga fugiat id itaque minus modi nam neque nisi non omnis placeat quia quidem quod ratione recusandae reprehenderit repudiandae similique sint sunt temporibus, veritatis voluptas?"));
//
//        posts.add(new Post(4, "03.27.2023", "Laudantium 4", "Debra Smith", "A accusantium ad animi asperiores, consectetur culpa dolor dolores, ducimus enim eos esse est fuga ipsum itaque iusto magni maxime minus modi molestiae quasi quia quibusdam quis quo, sapiente veniam?"));

        postDao.save(post);
        return "post created";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @PostMapping()
    public String inputPost(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}
