package com.example.fileuploading.Entity;


import jakarta.persistence.*;

@Entity
@Table

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] size;

}
