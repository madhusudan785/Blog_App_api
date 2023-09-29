package com.example.blog_app.Repositry;

import com.example.blog_app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
