package com.example.blog_app.Controller;

import com.example.blog_app.Config.AppConfig;
import com.example.blog_app.Payload.ApiResponse;
import com.example.blog_app.Payload.PostDto;
import com.example.blog_app.Payload.PostResponse;
import com.example.blog_app.Service.FileService;
import com.example.blog_app.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

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
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);

    }
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam (value = "pageNumber",defaultValue = AppConfig.PAGE_NUMBER,required = false)Integer pageNumber,
                                                    @RequestParam(value = "pageSize",defaultValue = AppConfig.PAGE_SIZE,required = false)Integer pageSize,
                                                    @RequestParam(value = "sortBy",defaultValue = AppConfig.SORT_BY,required = false)String sortBy
                                                   )
//    @RequestParam(value = "sortDir",defaultValue = AppConfig.SORT_DIR,required = false)String sortDir
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
    @GetMapping("/post/search/{keywords}")
        public ResponseEntity<List<PostDto>> searchTitle(@PathVariable String keywords){
        List<PostDto> searchPosts = this.postService.searchPost(keywords);
        return new ResponseEntity<>(searchPosts,HttpStatus.OK);

    }

    //post image upload
    @PostMapping("post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(@PathVariable Integer postId
            , @RequestParam("image")MultipartFile image) throws IOException {
        PostDto postDto = this.postService.getPostById(postId);
        String fileName = this.fileService.uploadingImage(path, image);

        postDto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postDto, postId);

        return  new ResponseEntity<>(updatePost,HttpStatus.OK);


    }


}
