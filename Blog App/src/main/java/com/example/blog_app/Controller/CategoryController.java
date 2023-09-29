package com.example.blog_app.Controller;

import com.example.blog_app.Payload.ApiResponse;
import com.example.blog_app.Payload.CategoryDto;
import com.example.blog_app.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto create_Category = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(create_Category, HttpStatus.CREATED);

    }
    @PutMapping ("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);

    }
    @DeleteMapping ("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
       this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category is deleted Successfully", true), HttpStatus.OK);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getSingleCategory(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
       List <CategoryDto> categoryDtos = this.categoryService.getAllCategory();
        return  ResponseEntity.ok(categoryDtos);

    }


}
