package com.example.blog_app.Service.impl;

import com.example.blog_app.Entity.Commennt;
import com.example.blog_app.Entity.Post;
import com.example.blog_app.Exception.ResourceNotFoundException;
import com.example.blog_app.Payload.CommentDto;
import com.example.blog_app.Repositry.CommentRepo;
import com.example.blog_app.Repositry.PostRepo;
import com.example.blog_app.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
     @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
        Commennt commennt = this.modelMapper.map(commentDto, Commennt.class);
        commennt.setPost(post);
        Commennt save = this.commentRepo.save(commennt);

        return this.modelMapper.map(save,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Commennt commnt = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment","commentId",commentId));
        this.commentRepo.delete(commnt);
    }
}
