package com.example.blog_app.Service;

import com.example.blog_app.Entity.Category;
import com.example.blog_app.Entity.Post;
import com.example.blog_app.Payload.PostDto;
import com.example.blog_app.Payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);



    PostDto updatePost(PostDto postDto, Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy);

    PostDto getPostById(Integer postId);

    void deletePost(Integer postId);

   PostResponse getPostByCategory(Integer categoryId,Integer pageNumber, Integer pageSize,String sortBy);

    List<PostDto> getPostByUser(Integer userId);

    List<Post> searchPost(String keyword);


}
