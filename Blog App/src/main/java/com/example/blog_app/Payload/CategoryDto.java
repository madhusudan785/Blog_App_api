package com.example.blog_app.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;

    @NotEmpty
    @Size(min = 4, message = "Min size should be more than 4 characters.")
    private String categoryTitle;

    @NotNull
    @Size(min = 10, message = "Min size should be more than 10 characters.")
    private String categoryDescription;
}
