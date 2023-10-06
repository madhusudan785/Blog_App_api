package com.example.blog_app.Controller;

import com.example.blog_app.Entity.Commennt;
import com.example.blog_app.Payload.ApiResponse;
import com.example.blog_app.Payload.CommentDto;
import com.example.blog_app.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
        CommentDto comment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
         this.commentService.deleteComment(commentId);
         return new ResponseEntity<>(new ApiResponse("comment deleted successfully",true),HttpStatus.OK);

    }
}
