package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;



    @GetMapping
    public String all(Model model) {

        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);

        List<Post> somePosts = postDao.findLikeName("a");
//        System.out.println(somePosts);

        return "posts/show";
    }

    @GetMapping("/{id}")
//    @ResponseBody
    public String viewPost(@PathVariable long id, Model model) {


        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
//        model.addAttribute("date", date);
//        model.addAttribute("title", title);
//        model.addAttribute("author", author);
//        model.addAttribute("body", body);


        return "/posts/individualPost";
    }

//    @GetMapping("/create")
//    @ResponseBody
//    public String createPost() {
//        System.out.println("link working");
//        Post post = new Post();
//        post.setTitle("Laboriosam 1");
//        post.setAuthor("Richard Carnation");
//        post.setDate("02.25.2023");
//        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");
//        post.setTitle("Laboriosam 1");
//        post.setAuthor("Richard Carnation");
//        post.setDate("02.25.2023");
//        post.setBody("Accusamus accusantium ad assumenda cum delectus error et facilis, perferendis quis quo repellat, totam vero voluptatum. A ab alias atque ex in itaque nemo perferendis recusandae ullam velit? Molestias, repellendus?");
////        posts.add(new Post(2, "03.05.2023", "Necessitatibus 2", "Richard Carnation", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequatur ea ex officia? Aliquam aut beatae incidunt iste laboriosam neque, quibusdam!"));
////
////        posts.add(new Post(3, "03.26.2023", "Inventores 3", "Todd Reynolds", "Aperiam architecto asperiores consectetur consequuntur cumque deleniti distinctio dolor dolore dolorem eius eligendi est exercitationem fuga fugiat id itaque minus modi nam neque nisi non omnis placeat quia quidem quod ratione recusandae reprehenderit repudiandae similique sint sunt temporibus, veritatis voluptas?"));
////
////        posts.add(new Post(4, "03.27.2023", "Laudantium 4", "Debra Smith", "A accusantium ad animi asperiores, consectetur culpa dolor dolores, ducimus enim eos esse est fuga ipsum itaque iusto magni maxime minus modi molestiae quasi quia quibusdam quis quo, sapiente veniam?"));
//
//        postDao.save(post);
//        return "post created";
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    @GetMapping("/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String addPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L);
        post.setUser(user);


        //        testing fields
        //        post.setTitle("title");
        //        post.setDate("date");
        //        post.setBody("body");
        //        testing

        postDao.save(post);
        emailService.prepareAndSend(user, "Post created", post.getTitle());

        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {

        Post oGPost = postDao.findById(id).get();
        post.setId(post.getId());
        post.setUser(oGPost.getUser());
        postDao.save(post);
        return "redirect:/posts/{id}";
    }
}
