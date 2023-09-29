package com.example.blog_app.Controller;

import com.example.blog_app.Payload.ApiResponse;
import com.example.blog_app.Payload.UserDto;
import com.example.blog_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> create_User(@RequestBody UserDto userDto) {
        UserDto create_user_dto = this.userService.createUser(userDto);
        return new ResponseEntity<>(create_user_dto, HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updateUser = this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updateUser);

    }
    @DeleteMapping("/{userId}")
    public  ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
    {
      this.userService.deleteUser(userId);
      return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted successfully",true),HttpStatus.OK);

    }

    @GetMapping("/getuser")
    public  ResponseEntity<List<UserDto>> get_user(){
        return  ResponseEntity.ok(this.userService.getAllUsers());

    }
    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto> get_single_user(@PathVariable Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));

    }

}
