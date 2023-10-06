package com.example.blog_app.Repositry;

import com.example.blog_app.Entity.Commennt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Commennt,Integer>  {

}
