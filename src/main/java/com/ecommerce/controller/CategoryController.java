package com.ecommerce.controller;

import com.ecommerce.payload.CategoryDTO;
import com.ecommerce.payload.CategoryResponse;
import com.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    // getting all the category
    @GetMapping("/api/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //creating a category
    @PostMapping("/api/public/categories")
    public ResponseEntity<CategoryDTO> crearteCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO saverCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(saverCategory, HttpStatus.CREATED);
    }

    //Deleting category
    @DeleteMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
        CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }

    // updating the category
    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {
        CategoryDTO saveCategory = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<CategoryDTO>(saveCategory, HttpStatus.OK);
    }
}
