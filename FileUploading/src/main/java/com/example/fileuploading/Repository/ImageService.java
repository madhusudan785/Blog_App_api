package com.example.fileuploading.Repository;

import com.example.fileuploading.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageService extends JpaRepository<Image,Long> {

}
