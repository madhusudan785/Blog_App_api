package com.example.blog_app.Service;

import com.example.blog_app.Payload.CategoryDto;
import com.example.blog_app.Payload.UserDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory(Integer categoryId);
    CategoryDto getSingleCategory(Integer categoryId);
    List<CategoryDto> getAllCategory();


}
