package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    Post findById(long id);
    List<Post> findByTitle(String title);
    List<Post> findByAuthor(String Author);

//    can add find by user id later
//    may need a separate repo...

    @Query("from Post p where p.title like %:name%")
    List<Post> findLikeName(@Param("name") String name);

}