package com.example.blog_app.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "User_name", nullable = false, length = 50)
    private String name;

    @Column(name = "User_email", nullable = false, length = 50)
    private String email;

    @Column(name = "User_pass", nullable = false, length = 20)
    private String password;

    @Column(name = "User_about", nullable = false, length = 100)
    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)//,fetch = FetchType.LAZY-> it helps us to store the data even if the parent table is deleted
    private List<Post> posts=new ArrayList<>();
}
