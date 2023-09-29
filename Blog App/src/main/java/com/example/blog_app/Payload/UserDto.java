package com.example.blog_app.Payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int id;

    private String name;
    private String email;
    private String password;
    private String about;

}
