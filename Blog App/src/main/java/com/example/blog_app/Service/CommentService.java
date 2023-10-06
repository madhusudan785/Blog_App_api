package com.example.blog_app.Service;

import com.example.blog_app.Payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);

}
