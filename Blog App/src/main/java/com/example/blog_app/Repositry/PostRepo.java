package com.example.blog_app.Repositry;

import com.example.blog_app.Entity.Category;
import com.example.blog_app.Entity.Post;
import com.example.blog_app.Entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

//    List<Post> findTitleContaining(String postTitle);
}
