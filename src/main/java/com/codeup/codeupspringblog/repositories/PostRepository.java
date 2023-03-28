package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    Post findById(long id);
    Post findByTitle(String name);
    List<Post> findByAuthor(String Author);

    @Query("from Post p where p.title like %:name%")
    List<Post> findLikeName(@Param("name") String name);

}