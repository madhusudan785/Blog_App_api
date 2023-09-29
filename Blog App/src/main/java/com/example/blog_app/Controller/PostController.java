package com.example.blog_app.Controller;

import com.example.blog_app.Payload.ApiResponse;
import com.example.blog_app.Payload.PostDto;
import com.example.blog_app.Payload.PostResponse;
import com.example.blog_app.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody  PostDto postDto, @PathVariable Integer categoryId, @PathVariable Integer userId){
        PostDto newPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
    @GetMapping("/User/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> postByUser = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(postByUser,HttpStatus.OK);

    }
    @GetMapping("/Category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId,
    @RequestParam(value="pageNumber",defaultValue = "0",required = false)Integer pageNumber,
          @RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue = "categoryId",required = false)String sortBy){
        PostResponse postByCategory = this.postService.getPostByCategory(categoryId,pageNumber,pageSize,sortBy);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);

    }
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam (value = "pageNumber",defaultValue = "0",required = false)Integer pageNumber,
                                                    @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize,
                                                    @RequestParam(value = "sortBy",defaultValue = "postId",required = false)String sortBy)
    {
       PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sortBy);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getSinglePostById(@PathVariable Integer postId){
        PostDto singlePostById  = this.postService.getPostById(postId);
        return new ResponseEntity<>(singlePostById,HttpStatus.OK);
    }
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePostById(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post Is Successfully deleted",true);

    }
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,@PathVariable Integer postId){
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);

    }


}
