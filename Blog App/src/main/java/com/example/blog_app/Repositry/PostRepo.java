package com.example.blog_app.Repositry;

import com.example.blog_app.Entity.Category;
import com.example.blog_app.Entity.Post;
import com.example.blog_app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("select p from  Post p where p.postTitle like:key ")
    List<Post> searchByTitleContaining(@Param("key") String postTitle);
}
